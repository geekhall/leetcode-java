#!/usr/bin/env python3
# -*- coding:UTF-8 -*-

from curses.ascii import isdigit
from traceback import print_tb
from capstone import cs_disasm_lite
from numpy import diff
import requests
import json
import os
import sys
from requests_toolbelt import MultipartEncoder
import pandas as pd
import matplotlib.pyplot as plt
import html_text
from problem_list import problem_dict
from functions import is_number

session = requests.Session()
user_agent = r'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36'
default_lang = 'typescript'
support_lang = [
    'typescript',
    'go',
    'java',
    'rust',
    'python'
]


class CrawlSlut:
    'Crawl leetcode problem description.'
    url = 'https://leetcode.com'

    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

    def displayUrl(self):
        print("LeetCode baseUrl: %s" % CrawlSlut.url)


def login(username, password):
    url = 'https://leetcode.com'
    cookies = session.get(url).cookies
    for cookie in cookies:
        if cookie.name == 'csrftoken':
            csrftoken = cookie.value

    url = "https://leetcode.com/accounts/login"

    params_data = {
        'csrfmiddlewaretoken': csrftoken,
        'login': username,
        'password': password,
        'next': 'problems'
    }
    headers = {'User-Agent': user_agent, 'Connection': 'keep-alive',
               'Referer': 'https://leetcode.com/accounts/login/', "origin": "https://leetcode.com"}
    m = MultipartEncoder(params_data)

    headers['Content-Type'] = m.content_type
    session.post(url, headers=headers, data=m,
                 timeout=10, allow_redirects=False)
    is_login = session.cookies.get('LEETCODE_SESSION') != None
    return is_login


session = requests.Session()
user_agent = r'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36'


def get_problems():
    url = "https://leetcode.com/api/problems/all/"

    headers = {'User-Agent': user_agent, 'Connection': 'keep-alive'}
    resp = session.get(url, headers=headers, timeout=10)

    question_list = json.loads(resp.content.decode('utf-8'))

    for question in question_list['stat_status_pairs']:
        # 题目编号
        question_id = question['stat']['question_id']
        # 题目名称
        question_slug = question['stat']['question__title_slug']
        # 题目状态
        question_status = question['status']

        # 题目难度级别，1 为简单，2 为中等，3 为困难
        level = question['difficulty']['level']

        # 是否为付费题目
        if question['paid_only']:
            continue


session = requests.Session()
user_agent = r'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36'


def get_problem_by_slug(slug):
    url = "https://leetcode.com/graphql"
    params = {'operationName': "getQuestionDetail",
              'variables': {'titleSlug': slug},
              'query': '''query getQuestionDetail($titleSlug: String!) {
            question(titleSlug: $titleSlug) {
                questionId
                questionFrontendId
                questionTitle
                questionTitleSlug
                content
                difficulty
                stats
                similarQuestions
                categoryTitle
                topicTags {
                        name
                        slug
                }
            }
        }'''
              }

    json_data = json.dumps(params).encode('utf8')

    headers = {'User-Agent': user_agent, 'Connection':
               'keep-alive', 'Content-Type': 'application/json',
               'Referer': 'https://leetcode.com/problems/' + slug}
    resp = session.post(url, data=json_data, headers=headers, timeout=10)
    content = resp.json()
    # print("content:" + str(content))
    # 题目详细信息
    question = content['data']['question']
    questionId = question['questionId']
    questionFrontendId = question['questionFrontendId'].rjust(5, '0')
    questionTitle = question['questionTitle']
    questionTitleSlug = question['questionTitleSlug']
    question_content = question['content']
    difficulty = question['difficulty']

    # headers_cn = {'User-Agent': user_agent, 'Connection':
    #               'keep-alive', 'Content-Type': 'application/json',
    #               'Referer': 'https://leetcode-cn.com/problems/' + slug}
    # resp_cn = session.post(url_cn, data=json_data,
    #                        headers=headers_cn, timeout=10)
    # content_cn = resp_cn.json()
    # question_cn = content_cn['data']['question']
    # content_cn = question_cn['translatedContent']
    # content_cn = question_cn['content']
    # print("question_content:" + str(question_content))
    return questionFrontendId, questionTitleSlug, questionTitle, difficulty, question_content


'''
write to csv file
'''


def write_to_csv(file_name, list_data):
    df = pd.DataFrame(list_data)
    df.to_csv(file_name, index=False)


def get_id_range(id):
    range_id = str(int(int(id) / 100)).zfill(3)
    return "p"+range_id+"00"


def config_directory(id, slut):
    workbase_dir = '/Users/yiny/workspace/leetcode-java/problems/src/'
    mainbase_dir = workbase_dir + 'main/java/cn/geekhall/problems/'
    testbase_dir = workbase_dir + 'test/java/cn/geekhall/problems/'
    id_range = get_id_range(id)
    package_dir = mainbase_dir + id_range
    if not os.path.exists(package_dir):
        os.mkdir(package_dir)
    slut_dir = package_dir + "/p"+id.zfill(5)
    if not os.path.exists(slut_dir):
        os.mkdir(slut_dir)
    return slut_dir


def file_exists(id, slut):
    slut_dir = config_directory(id, slut)
    solution_file = slut_dir + "/Solution" + id + ".java"
    readme_file = slut_dir + "/README.md"
    readme_file_cn = slut_dir + "/README.zh-CN.md"
    if not os.path.exists(solution_file):
        # print("solution file not exists", solution_file)
        return False
    if not os.path.exists(readme_file):
        # print("readme file not exists", readme_file)
        return False
    if not os.path.exists(readme_file_cn):
        # print("cn version readme file not exists", readme_file_cn)
        return False
    cmdline = 'code -r '+solution_file
    os.system(cmdline)
    return True


def write_solution(solution_file, id, title, difficulty, content_text):
    id_range = get_id_range(id)
    sf = open(solution_file, 'w')
    sf.write("package " + "cn.geekhall.problems." +
             id_range + ".p" + id + ";\n")
    sf.write("\n")
    sf.write("/**\n")
    sf.write(" * ID:    " + id + "\n")
    sf.write(" * Title: " + title + "\n")
    sf.write(" * Difficulty: " + difficulty + "\n")
    sf.write(" * Description: " + content_text + "\n")
    sf.write(" */\n")
    sf.write("class Solution"+id+" {\n")
    sf.write("\n")
    sf.write("  public static void solution(){\n")
    sf.write("    System.out.println(\"solution\");\n")
    sf.write("  }\n")
    sf.write("\n")
    sf.write("  public static void test_" + id + "() {\n")
    sf.write("    Solution" + id + ".solution();\n")
    sf.write("  }\n")
    sf.write("\n")
    sf.write("  public static void main(String[] args) {\n")
    sf.write("    Solution"+id+".test_" + id + "();\n")
    sf.write("  }\n")
    sf.write("}\n")
    sf.write("\n")
    sf.close()


def write_readme(readme_file, id, title, content):
    sf = open(readme_file, 'w')
    sf.write("# " + id + ". " + title + "\n")
    sf.write("\n")
    sf.write("  _Read this in other languages:_\n")
    sf.write("    [_简体中文_](README.zh-CN.md)\n")
    sf.write("\n")
    sf.write(content)
    sf.close()


def write_cn_readme(readme_file, id, title, content):
    sf = open(readme_file, 'w')
    sf.write("# " + id + ". " + title + "\n")
    sf.write("\n")
    sf.write("  _Read this in other languages:_\n")
    sf.write("    [_English_](README.md)\n")
    sf.write("\n")
    sf.write(content)
    sf.close()


def save_file(id, slut, title, difficulty, content):
    slut_dir = config_directory(id, slut)
    solution_file = slut_dir + "/Solution" + id + ".java"
    readme_file = slut_dir + "/README.md"
    readme_file_cn = slut_dir + "/README.zh-CN.md"
    content_text = html_text.extract_text(content).replace('\n', '\n * ')
    if not os.path.exists(solution_file):
        write_solution(solution_file, id, title, difficulty, content_text)
    if not os.path.exists(readme_file):
        write_readme(readme_file, id, title, content)
    if not os.path.exists(readme_file_cn):
        write_cn_readme(readme_file_cn, id, title, content)

    cmdline = 'code -r '+solution_file
    os.system(cmdline)


def create_single_slug(id):
    slut = problem_dict[id]
    if not file_exists(id, slut):
        print("EEEEEEnter")
        questionFrontendId, questionTitleSlug, questionTitle, difficulty, content = get_problem_by_slug(
            slut)
        save_file(questionFrontendId, questionTitleSlug,
                  questionTitle, difficulty, content)


if __name__ == '__main__':
    if len(sys.argv) != 2:
        print("Usage: cj leetcode_id")
        exit(-1)
    else:
        leetcode_id = str(sys.argv[1])
        if is_number(leetcode_id):
            id = leetcode_id
            try:
                slut = problem_dict[id]
                need_access = False
            except:
                print("Except : ")
            # if not file_exists(id, slut):
            #     need_access = True
            #     print("File exist")
            # if need_access:
            #     print("File Not exist, Need access")
            create_single_slug(id)
