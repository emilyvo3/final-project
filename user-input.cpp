// Emily Vo
// Final Project: In this program, we first define a map called users to store the user data. The key of the map is the username, 
//and the value is a pair containing the password and courses enrolled. We then prompt the user to enter their username, password, and courses enrolled. 
//We store this data in the users map using the make_pair function to create a pair from the password and courses strings.
//Finally, we print out the user data stored in the users map using a range-based for loop to iterate over the key-value pairs in the map.
// CS 302
// 3/5/23
// Partner: Dhwani Patel
#include <iostream>
#include <string>
#include <map>
using namespace std;

int main(int argc, char *argv[])
{
    // define map to store user data
    map<string, pair<string, string>> users;
    string username, password, courses;

    // get user input for username, passord, and courses
    cout << "Enter username: ";
    //cin >> username;
    getline(cin, username);
    cout << "Enter password: ";
    //cin >> password;
    getline(cin, password);
    cout << "Enter courses (ex. format: CS302, CS311): ";
    //cin >> courses;
    getline(cin, courses);

    // store user data in map
    users[username] = make_pair(password, courses);

    // print user data stored in map
    cout << "\nUser data stored in map:\n";
    for (map<string, pair<string, string>>::const_iterator it = users.begin(); it != users.end(); ++it) // source: GeeksforGeeks
    {
        cout << "Username: " << it->first << endl;
        cout << "Password: " << it->second.first << endl;
        cout << "Courses: " << it->second.second << endl;
    }
    return 0;
}