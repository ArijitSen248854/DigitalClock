package com.practice;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.event.*;

public class clock
{
    public static void main(String[] args)
    {
        ////set the window for the clock  using JAVA SWING(JFrame)
        JFrame clock =new TextClockWindow();
        clock.setBounds(500,180,555,150);
        Container c=clock.getContentPane();
        c.setBackground(Color.BLACK);
        clock.setResizable(false);
        clock.setUndecorated(true);/////////

        clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clock.setVisible(true);
    }
    //JFrame is a class that will help us to create graphical Java applications
}


class TextClockWindow extends JFrame
{
    //Inheritance can be defined as the procedure or mechanism of acquiring all the properties and behavior of one class to anther.

    private JTextField timeField;
    // the private keyword is an access modifier used for attributes ,methods and constructors , making them onlu accessible within
    private JTextField dateField;
    public TextClockWindow()
    {


      //  timeField.setBounds(100,50,120,30);
      //  dateField.setBounds(100,50,120,30);
        //set the size of the textboxes
        timeField = new JTextField(10);
        dateField = new JTextField(10);

        //set the font style,size, background color using swing
        timeField.setFont(new Font("Verdana",Font.CENTER_BASELINE,50));
        timeField.setForeground(new Color(0x00FF00));
        timeField.setBackground(Color.black);
        dateField.setFont(new Font("Verdana",Font.CENTER_BASELINE,50));
        dateField.setForeground(new Color(0x00FF00));
        dateField.setBackground(Color.black);

        Container content = this.getContentPane();
        content.setLayout(new FlowLayout());
        content.add(timeField);
        content.add(dateField);

        this.setTitle("Digital Clock BY : Arijit Sen");
        //this.pack();

        //'this' : keyword in Java is a referance variable that refers to the current object of method or a constructor

        javax.swing.Timer t=new javax.swing.Timer(1000,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Calendar calendar = new GregorianCalendar();
                        String am_pm;

                        Calendar now = Calendar.getInstance();
                        int h = now.get(Calendar.HOUR_OF_DAY);
                        int m = now.get(Calendar.MINUTE);
                        int s = now.get(Calendar.SECOND);
                        int d=  now.get(Calendar.DATE);
                        int day=now.get(Calendar.DAY_OF_WEEK);
                        //Calendar class gives the integer number as a return type, so we use switch-case to find the perticular day
                        String pday="";
                        switch(day)
                        {
                            case 2:
                                pday= "MON" ;
                                break;
                            case 3:
                                pday= "TUE" ;
                                break;
                            case 4:
                                pday= "WED" ;
                                break;
                            case 5:
                                pday= "THU" ;
                                break;
                            case 6:
                                pday= "FRI" ;
                                break;
                            case 7:
                                pday= "SAT" ;
                                break;
                            default:
                                pday= "SUN" ;
                                break;
                        }

                        //Calendar class gives the integer number as a return type, so we use switch-case to find the perticular month
                        int mo=  now.get(Calendar.MONTH);
                        String monthString;
                        switch (mo) {
                            case 0:  monthString = "Jan";
                                break;
                            case 1:  monthString = "Feb";
                                break;
                            case 2:  monthString = "Mar";
                                break;
                            case 3:  monthString = "Apr";
                                break;
                            case 4:  monthString = "May";
                                break;
                            case 5:  monthString = "June";
                                break;
                            case 6:  monthString = "July";
                                break;
                            case 7:  monthString = "Aug";
                                break;
                            case 8:  monthString = "Sep";
                                break;
                            case 9: monthString = "Oct";
                                break;
                            case 10: monthString = "Nov";
                                break;
                            case 11: monthString = "Dec";
                                break;
                            default: monthString = "Invalid month";
                                break;
                        }

                        int y=  now.get(Calendar.YEAR);

                        if (calendar.get(Calendar.AM_PM) == 0) {
                            am_pm = "AM";
                        } else {
                            am_pm="PM";
                        } //Code to Determine whether the time is AM or PM

                        timeField.setText(""+h+ ":"+m+":"+s+":"+am_pm);
                        timeField.setHorizontalAlignment(JTextField.CENTER);
                        //Center the text
                        timeField.getCaret().setVisible(false);
                        //Hide the Cursor in JTextField

                        dateField.setText(""+pday+" ,"+d+" "+monthString+" "+y);
                        dateField.setHorizontalAlignment(JTextField.CENTER);
                        //Center the text
                        dateField.getCaret().setVisible(false);
                        //Hide the Cursor in JdateField

                    }
                });
        t.start();
    }

}  // End of the code