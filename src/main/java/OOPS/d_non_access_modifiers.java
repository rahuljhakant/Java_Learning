package OOPS;

/*
 * Final
 * Static
 * Transient
 * Synchronized
 * Volatile
 * */

final class d_non_access_modifiers {}

class d_non_access {

  final String happy() {
    return "";
  }
}

class happy extends d_non_access {
  /*
 'happy()' cannot override 'happy()' in 'OOPS.d_non_access'; overridden method is final
    final String happy() {
        return "";
    }
*/
}

class syc {

  volatile int c = 10;

  synchronized String abc() {
    this.c = 20;
    return "";
  }
}
