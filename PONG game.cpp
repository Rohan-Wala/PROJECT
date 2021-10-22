#include<iostream>
#include<time.h>
#include<conio.h>
#include<windows.h>
using namespace std;
enum eDir{
	STOP=0,
	Left=1,upleft=2,downleft=3,
	Right=4,upright=5,downright=6
	};
class cBall{
	
	private:
		int x,y;
		int originalx,originaly; 
		eDir direction; 
		
	public:
		cBall(int posx,int posy){
			// to store the position of ball
			originalx = posx; originaly = posy;
			x = posx; y = posy;
			direction = STOP;
		}
		
		void reset(){
			x = originalx;
			y = originaly;
			direction = STOP;
		}
		void changeDirection(eDir d){
			direction = d;
		}
		void randomDirection(){
			direction = (eDir)((rand() % 6) + 1);
		}
		inline int getx(){ return x;}
		inline int gety(){ return y;}
		inline eDir getDirection(){return direction;}
		
		void Move(){
			switch(direction){
				case STOP:
					break;
				case Left:
					x--;
					break;
				case Right:
					x++;
					break;
				case upleft:
					y--;
					x--;
					break;
				case downleft:
					y++;
					x--;
					break;
				case upright:
					y--;
					x++;
					break;
				case downright:
					y++;
					x++;
					break;
				default:
					break;
			}
		}
	friend ostream & operator<<(ostream & o,cBall c){
		o << "Ball [" <<c.x << ","<< c.y<<"]["<<c.direction<<"]"<<endl;
//		return 0;
	}
		
};
class cPaddle{
	private:
		int x,y;
		int originalx,originaly;
	public:
		cPaddle(){
			x=y= 0;
		}
		cPaddle(int posx,int posy) : cPaddle(){
			originalx = posx;
			originaly = posy;
			x =	posx;
			y =	posy;
		}
		inline void reset(){
			x = originalx;
			y = originaly; 
		}
		inline int getx(){ return x;}
		inline int gety(){ return y;}
		inline void moveup(){ y--;}
		inline void movedown(){ y++;}
		friend ostream & operator<<(ostream & o,cPaddle c){
		o << "paddle [" <<c.x << ","<< c.y<<"]"<<endl;
//		return 0;
	}
};
class cGameManager{
	private:
		int width,height;
		int score1,score2;
		char up1,up2,down1,down2;
		bool quit;
		cBall *ball;
		cPaddle *player1;
		cPaddle *player2;
		
	public:
		cGameManager( int w, int h){
			srand(time(NULL));
			quit = false;
			up1 = 'w'; up2 = 'i';
			down1 = 's'; down2 = 'k';
			score1 = score2 = 0;	
			width = w; height = h;
			ball = new cBall(w/2,h/2);
			player1 = new cPaddle(1,h/2 -3);
			player2 = new cPaddle(w-2,h/2 -3);	
		}
		~cGameManager()
		{
			//to delete dynamic memory
			delete ball,player1,player2;
		}
		void scoreup(cPaddle *player){
			if(player == player1)
				score1++;
			else if(player == player2)
				score2++;
				
			ball->reset();
			player1->reset();
			player2->reset();
		}
		void draw()
		{
			system("cls");
			for(int i=0;i<width+2;i++)
				cout<<"\xB2";	
			cout<<endl;	
			
			for(int i=0;i<height;i++){
				for(int j=0;j<width;j++){
					
					int ballx = ball->getx();
					int bally = ball->gety();
					int player1x = player1->getx();
					int player1y = player1->gety();
					int player2x = player2->getx();
					int player2y = player2->gety();
					/*
					 	win+r->charmap->ok->select the char and see tha hex value of that char 
					*/
					if(j==0)
						cout<<"\xB2";//hex value of that char 
						
					if(ballx == j && bally == i)
						cout<<"O";//ball
					else if(player1x == j && player1y == i)
						cout<<"\xDB";//player 1
					else if(player2x == j && player2y == i)
						cout<<"\xDB";//player 2
					
					
					// to draw the big paddle of size 4
					else if(player1x == j && player1y +1 == i)
						cout<<"\xDB";//player 1
					else if(player1x == j && player1y +2 == i)
						cout<<"\xDB";//player 1
					else if(player1x == j && player1y +3 == i)
						cout<<"\xDB";//player 1
					
					else if(player2x == j && player2y +1== i)
						cout<<"\xDB";//player 2
					else if(player2x == j && player2y +2== i)
						cout<<"\xDB";//player 2
					else if(player2x == j && player2y +3== i)
						cout<<"\xDB";//player 2	
					
					else cout<<" ";
						
					if(j == width-1)
						cout<<"\xB2";	
				}
				cout<<endl;
			}	
				
			for(int i=0;i<width+2;i++)
				cout<<"\xB2";
			cout<<endl;
			cout<<"player1:"<<score1<<" 	"<<"player2:"<<score2;
		}
		void input(){
			ball->Move();
			int ballx = ball->getx();
			int bally = ball->gety();
			int player1x = player1->getx();
			int player1y = player1->gety();
			int player2x = player2->getx();
			int player2y = player2->gety();
			
			if(_kbhit()){
				char current = _getch();
				if(current == up1)
					if(player1y >0)
						player1->moveup();
				if(current == up2)
					if(player2y >0)
						player2->moveup();
				if(current == down1)
					if(player1y+4 < height )
						player1->movedown();
				if(current == down2)
					if(player2y+4 < height)
						player2->movedown();
						
				if(ball->getDirection() == STOP)
					ball->randomDirection();
					
				if(current == 'q')
					quit = true;		
			}	
		}
		void logic(){
			int ballx = ball->getx();
			int bally = ball->gety();
			int player1x = player1->getx();
			int player1y = player1->gety();
			int player2x = player2->getx();
			int player2y = player2->gety();
			//for left paddle
			for( int i=0;i<4;i++){
				if(ballx == player1x +1)
					if(bally == player1y+i)
						ball->changeDirection((eDir)((rand() % 3) +4));
			}
			//for right paddle
			for( int i=0;i<4;i++){
				if(ballx == player2x -1)
					if(bally == player2y+i)
						ball->changeDirection((eDir)((rand() % 3) +1));
			}	
			
			//bottem wall
			if(bally == height-1)
				ball->changeDirection(ball->getDirection() == downright ? upright : upleft);
			//top wall
			if(bally == 0)
				ball->changeDirection(ball->getDirection() == upright ? downright : downleft);
			//right wall
			if(ballx == width-1)
				scoreup(player1);
			//left wall
			if(ballx == 0)
				scoreup(player2);
		}
		void run(){
			while(!quit){
				draw();
				input();
				logic();
				Sleep(10);
			
			}
		}
		
};
int main(){
	
	cGameManager c(40,20);
	c.run();
	
	return 0;
}
