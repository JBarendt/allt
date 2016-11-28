#include <ros.h>
#include <std_msgs/Bool.h>
#include <std_msgs/String.h>
#include <std_msgs/Int32.h>
#include <std_msgs/Empty.h>
#include <Race/drive_values.h>
ros::NodeHandle  nh;


boolean flagStop = false;
int pwm_center_value = 9830;  //  15% duty cycle
int pwm_lowerlimit = 6554;    //  10% duty cycle
int pwm_upperlimit = 13108;   //  20% duty cycle

std_msgs::Int32 str_msg;
ros::Publisher chatter("chatter", &str_msg);

int kill_pin = 2;
unsigned long duration = 0;

void messageDrive( const Race::drive_values& pwm )
{
  Serial.print("Pwm drive : ");
  Serial.println(pwm.pwm_drive);
  Serial.print("Pwm angle : ");
  Serial.println(pwm.pwm_angle);
  
  if(flagStop == false)
  {
    str_msg.data = pwm.pwm_drive;
    chatter.publish( &str_msg );

    if(pwm.pwm_drive < pwm_lowerlimit)
    {
      analogWrite(5,pwm_lowerlimit);    //  Safety lower limit        
    }
    else if(pwm.pwm_drive > pwm_upperlimit)
    {
      analogWrite(5,pwm_upperlimit);    //  Safety upper limit
    }
    else
    {
      analogWrite(5,pwm.pwm_drive);     //  Incoming data                    
    }

    
    if(pwm.pwm_angle < pwm_lowerlimit)
    {
      analogWrite(6,pwm_lowerlimit);    //  Safety lower limit        
    }
    else if(pwm.pwm_angle > pwm_upperlimit)
    {
      analogWrite(6,pwm_upperlimit);    //  Safety upper limit
    }
    else
    {
      analogWrite(6,pwm.pwm_angle);     //  Incoming data                    
    }

  }
  else
  {
    analogWrite(5,pwm_center_value);
    analogWrite(6,pwm_center_value);    
  }
}

ros::Subscriber<Race::drive_values> sub_drive("drive_pwm", &messageDrive );


void setup() {
  
  analogWriteFrequency(5, 100);
  analogWriteFrequency(6, 100);
  analogWriteResolution(16);
  analogWrite(5,pwm_center_value);
  analogWrite(6,pwm_center_value);
  pinMode(2,OUTPUT); 
  digitalWrite(2,HIGH);


  nh.initNode();
  nh.subscribe(sub_drive);

  nh.advertise(chatter);
}

void loop() {
  nh.spinOnce();
  // put your main code here, to run repeatedly:
  delay(1);
}

