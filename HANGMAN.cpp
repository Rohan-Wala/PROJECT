#include<iostream>
#include<stdlib.h>
#include<vector>
#include<fstream>
#include<string>
#include<time.h>
using namespace std;
// to print the line and message
void PrintMessage(string message, bool printTop = true,bool printBottem  = true){
     if(printTop){
        cout<<"+----------------------------------+"<<"\n";
        cout<<"|";
     }
     else{
         cout<<"|";
     }
     // to print the message in center
     bool front = true;
     for(int i= message.length();i<34;i++){
        // for 1st iteration it will add sapce in fornt 
        //  then because of fornt = !front it will add space in back
        //  then again fron = !front so will add space in front
         if(front){
             message = " "+ message;
         }
         else{
             message = message + " ";
         }
         front = !front;
     }
     cout<<message.c_str();
    //  cout<<"\n";
     if(printBottem){
         cout<<"|"<<"\n";
         cout<<"+----------------------------------+"<<"\n";
     }
     else{
         cout<<"|"<<"\n";
     }
}

void Draw(int guessCount = 0){
    if( guessCount >=1 )
        PrintMessage("|",false,false);
    else
        PrintMessage("",false,false);
    if( guessCount >=2 )
        PrintMessage("|",false,false);
    else
        PrintMessage("",false,false);
    if( guessCount >=3 )
        PrintMessage("O",false,false);
    else
        PrintMessage("",false,false);
    if( guessCount ==4 )
        PrintMessage("/ ",false,false);
    if( guessCount ==5 )
        PrintMessage("/|",false,false);
    if( guessCount >=6 )
        PrintMessage("/|\\",false,false);
    else
        PrintMessage("",false,false);
    if( guessCount >=7 )
        PrintMessage("|",false,false);
    else
        PrintMessage("",false,false);
    if( guessCount ==8 )
        PrintMessage("/",false,false);
    if( guessCount >=9 )
        PrintMessage("/ \\",false,false);
    else
        PrintMessage("",false,false);
      
    
}
void PrintLetters(string input , char from , char to){
    // to see if guessed word are ther in string or not
    string s;
    for(char i= from; i<= to ;i++){
        if(input.find(i) == string::npos){ // if dont find the letter
            s += i;
            s += " ";
        }
        else
            s += "  ";  
    }
    PrintMessage(s, false ,false);
}
void PritAvailableLetters(string taken){
    // to print remainig letters
    PrintMessage("Available Letters");
    PrintLetters(taken,'A', 'M');
    PrintLetters(taken,'N', 'Z');
}
bool PrintWordAndCheckWin(string word , string guessed){
    bool won = true;
    string s ;
    for(int i = 0 ; i < word.length() ; i++){
        if(guessed.find(word[i]) == string::npos ){
            won = false;
            s += "_ ";
        }
        else{
            s += word[i];
            s += " "; 
        }
    }
    PrintMessage(s,false);
    return won;
}
string LoadRamdomWords(string fpath){
    int linecount = 0;
    string word;
    vector<string> v;
    ifstream reader(fpath.c_str());
    if(reader.is_open()){
        while(std::getline(reader,word))
            v.push_back(word);

        int randomline = rand() % v.size();

        word = v.at(randomline);
        reader.close();
    }
    return word;

}

int TriesLeft(string word,string guessed){
    int error = 0;
    for(int i=0;i< guessed.length();i++){
        if(word.find(guessed[i]) == string::npos)
            error++;
    }
    return error;
}
int main(){
    srand(time(0)); // as we run a rand() it give same word all the time to avois that we use this
    string guesses;
    string wordToGuesses;
    wordToGuesses = LoadRamdomWords("Words.txt");
    // cout<<wordToGuesses<<"\n";
    int tries = 0;
    bool win = false;
    do{
        system("cls");
        PrintMessage("HANGMAN IS COOL");
        Draw(tries);
        PritAvailableLetters(guesses);
        PrintMessage("Guess the Word");
        win = PrintWordAndCheckWin(wordToGuesses , guesses);
        if(win)
            break;
        char x;
        cout<<">";cin>>x;
        if(guesses.find(x) == string::npos)
            guesses += x;
        
        tries = TriesLeft(wordToGuesses,guesses);

    }while(tries < 10 );
    if (win)
        PrintMessage("YOU WON!");
    else
        PrintMessage("GAME OVER");
    
    system("pause");
    return 0;
}
/*
+----------------------------------+
|          HANGMAN IS COOL         |
+----------------------------------+
|                 |                |
|                 |                |
|                 O                |
|                /|\               |
|                 |                |
|                / \               |
|             +-------+            |
|             |       |            |
+----------------------------------+    
|         Available Letters        |    
+----------------------------------+    
|        B C   F G  I  K L M       |    
|      O P Q  S T U V W X Y Z      |    
+----------------------------------+    
|          Guess the Word          |    
+----------------------------------+    
|           A _ E _ E _            |    
+----------------------------------+  
*/