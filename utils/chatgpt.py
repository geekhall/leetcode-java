#!
#!/usr/bin/env python3
# -*- coding:UTF-8 -*-

import os
import openai

if __name__ == '__main__':
    api_org = os.getenv("OPENAI_API_ORG")
    api_key = os.getenv("OPENAI_API_KEY")
    print("=====================================")
    print(api_key)
    print("=====================================")
    openai.organization = api_org
    openai.api_key = api_key
    print(openai.Model.list())

    print("test")≈
