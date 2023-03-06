#include <iostream>
#include <string>
#include <map>

using namespace std;

int main(){
	string netid, password, course;
	int ncourses;
	map<string, string> tutorcourse; 
//	map<string, string>::iterator it;
	
	cout<<"Enter Net ID (enter 'abc' to check): ";
	cin>>netid;

	cout<<"Enter password (enter 'smokey' to check): ";
	cin>>password;
	cout<<endl;

	if(netid.compare("abc") == 0 && password.compare("smokey") == 0){
		cout<<"How many courses do you offer? ";
		cin>>ncourses;
		for(int i = 0 ; i < ncourses; i++){
			cout<<"Enter course #"<<(i + 1)<<" : ";
			cin>>course;

			tutorcourse.insert(make_pair(netid, course));
			course = " ";
		}
		
		map<string, string>::iterator it;

		cout<<netid<<" offers :"<<endl;
		for(it = tutorcourse.begin(); it != tutorcourse.end(); it++){
			cout<<"		"<<it->second<<endl;
		}
	}
	else if(!netid.compare("abc")){
		cout<<"Incorrect Net ID!"<<endl;
		return 0;
	}
	else{
		cout<<"Incorrect password!"<<endl;
		return 0;

	}

	return 0;
}
