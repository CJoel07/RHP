#include <iostream>
#include <string>

using namespace std;

int main() {
    string s;
    cin >> s;
    int len = s.length();
    
    for (int i = 1; i < (1 << len); i++) {
        string combi = "";
        for (int sh = 0; sh < len; sh++) {
            if ((i & (1 << sh)) > 0) {
                combi += s[sh];
            }
        }
        cout << combi << "\n";
    }

    return 0;
}
