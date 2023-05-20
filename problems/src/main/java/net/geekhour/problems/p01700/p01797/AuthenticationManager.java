package net.geekhour.problems.p01700.p01797;

import java.util.HashMap;

public class AuthenticationManager {
  private int timeToLive;
  private HashMap<String, Integer> map = new HashMap<>();

  public AuthenticationManager(int timeToLive) {
    this.timeToLive = timeToLive;
  }

  public void generate(String tokenId, int currentTime) {
    map.put(tokenId, currentTime + timeToLive);
  }

  public void renew(String tokenId, int currentTime) {
    if (map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
      map.put(tokenId, currentTime + timeToLive);
    }
  }

  public int countUnexpiredTokens(int currentTime) {
    int count = 0;
    for (String key : map.keySet()) {
      if (map.get(key) > currentTime) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    AuthenticationManager authenticationManager = new AuthenticationManager(5); // Constructs the AuthenticationManager
                                                                                // with timeToLive = 5 seconds.
    authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
    authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
    System.out.println(authenticationManager.countUnexpiredTokens(6)); // The token with tokenId "aaa" is the only
                                                                       // unexpired one at time 6, so return 1.
    authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
    authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8
                                           // the renew request is ignored, and nothing happens.
    authenticationManager.renew("bbb", 10); // The token with
    System.out.println(authenticationManager.countUnexpiredTokens(15)); // The token with tokenId "bbb" expires at time
                                                                        // 15, and the token with tokenId "aaa" expired
                                                                        // at time 7, so currently no token is
                                                                        // unexpired, so return 0.

  }
}
