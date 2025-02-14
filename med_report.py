#!C:\Users\magaj\AppData\Local\Programs\Python\Python313\python.exe

from javax.swing import *
from java.awt import *
from javax.swing.table import DefaultTableModel
import mysql.connector
import configparser
import MySQLdb.cursors

class Report:
  
def __init__(self):
    try:
        config.read('config.ini')
        mydb=mysql.connector.connect(host = config['mysqlDB']['host'],
               user = config['mysqlDB']['user'],
               passwd = config['mysqlDB']['pass'],
               db = config['mysqlDB']['db'])

        mycursor = mydb.cursor(prepared=True, dictionary=True)    
        query = 'SELECT * FROM tblappointment'
        mycursor.execute(query)
        myresult = mycursor.fetchall()

        frame = JFrame("hospitalSys - Patients Appointments")
        frame.setSize(1400, 1150)
        frame.setLayout(BorderLayout())


        JLabel label = new JLabel()
        label.setText( "Patients Appointments" )
        label.setForeground( Color.black )
        //label.setSize(300, 200)
        scrollPane.add(label);  

        String[] column= {"ID","AppointmentNo","Name","MobileNumber", "Email","AppointmentDate","AppointmentTime","Specialization","Doctor", "Message"};

        scrollPane = JScrollPane()
        scrollPane.setPreferredSize(Dimension(300,100))

        for row in myresult:
              jt1 = new javax.swing.JTable(row,column)

        scrollPane.add(label)
        scrollPane.setViewportView(jt1)

    except mysql.connector.Error as e:
        print("Error Connecting To Database:", e)
    finally:
        if connection.is_connected():
            connection.close()
            cursor.close()
            print("connection closed")
if __name__ == '__main__':
         Report()
