import javax.swing.*;
import java.awt.event.*; 
import java .awt.*;
import java.io.*;
import java.util.Scanner;

class Swing extends JFrame
{
	JButton b;
	JTextField user;
	JPasswordField pass;
	JLabel l1,l2;

	public Swing()
	{	
		JFrame fr=new JFrame("Main");
		
	    setLayout(new FlowLayout());
	    JPanel p = new JPanel();

	    l1=new JLabel("Username");
	    l1.setFont(new Font("Serif", Font.BOLD, 14));
		user=new JTextField("",12);

		l2=new JLabel("Password");
		l2.setFont(new Font("Serif", Font.BOLD, 14));
		l2.setBounds(30,80,60,30);
		pass=new JPasswordField("",12);


		b=new JButton("Submit");
		b.setBackground(new Color(146, 244, 66));



		b.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent ae)
        {
        String val1 = user.getText();
        String val2=pass.getText();
                 if((val1.equals("Vivek"))&&(val2.equals("Vivek")))
                 {
            	  fr.dispose();
				 First fst=new First();
				
                 }  	
                 
        }
        });

		
				  
		p.add(l1);		  
		p.add(user);
		p.add(l2);
		p.add(pass);
		p.add(b);
		

		fr.add(p);


		p.setBackground(new Color(255, 131, 6));
		p.setSize(600,400);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		fr.setSize(600,400);		
	}

	public static void main(String arg[]) 
	{
		Swing sr=new Swing();
	}

}




class First extends JFrame
{
     First()
   {

   		JTextField src,dest;
	    JLabel l1,l2;
	    JButton  Pack ,Unpack,back;

		JFrame fr=new JFrame("Pack and Unpack");
		
	    setLayout(new FlowLayout());
	    JPanel p = new JPanel();

	    back=new JButton("Back");
	    back.setBackground(new Color(255, 0, 255));
	    Pack=new JButton("Pack");
	    Pack.setBackground(new Color(128, 255, 0));
	    Unpack=new JButton("UnPack");
	    Unpack.setBackground(new Color(24, 105, 22));


	    back.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent ae)
        {   
        	fr.dispose();	    
     		Swing sr=new Swing();    
        }
        });


	    Pack.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent ae)
        {       
     	  Pack pk=new Pack();
     	  fr.dispose();    
        }
        });


	    Unpack.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent ae)
        {       
     	  Unpack unp=new Unpack();
     	  fr.dispose();    
        }
        });

	    p.add(Pack);
	    p.add(Unpack);	
	    p.add(back);


        fr.add(p);


		p.setBackground(new Color(255, 131, 6));
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		fr.setSize(600,400);

   }
}

class Unpack
{
	
	Unpack()
	{
		JLabel l1,l2;
	    JTextField t1,t2;
	    JButton Back,Unpack;
	     
		JFrame unp=new JFrame("Unpack Window");
		

	    
	    JPanel p = new JPanel();

	    l1=new JLabel("Enter File Name");
	   
	    t1=new JTextField("Folder name",16);
	   

	    Back=new JButton("Back");
	    Back.setBackground(new Color(255, 0, 255));

	    Unpack=new JButton("UnPack it");
	    Unpack.setBackground(new Color(24, 105, 22));

	      p.add(l1);
	    p.add(t1);
	 
	    p.add(Unpack);
	    p.add(Back);

	    unp.add(p);



	    p.setBackground(new Color(255, 131, 6));
		unp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unp.setVisible(true);
		unp.setSize(600,400);





	    Back.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent ae)
        {   
        	unp.dispose();	    
     		First fst=new First();    
        }
        });



	    Unpack.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent ae)
        {   
        	JDialog d = new JDialog(unp, "Congrats"); 
  
            // create a label 
            JLabel l = new JLabel("Successfully UnPacked the File"); 
  
            d.add(l); 
  
            // setsize of dialog 
            d.setSize(200, 200); 
  
            // set visibility of dialog 
            d.setVisible(true); 
            d.setBackground(Color.green);
        	String val1 = t1.getText();
        	try{

		File file = new File(val1);
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	//FileInputStream fin=new FileInputStream("name2.txt");

	String line=null;
	String x[]=null;

	while((line=br.readLine())!=null)
	{
		//System.out.println(line);

		x=line.split(" ");
		String name=x[0];
		 String length=x[1];
		 int len=Integer.parseInt(length);

		// for(String tmp:x)
		// {
		// 	System.out.println(tmp);
		// }
		

		 //System.out.print("Name:"+name+"\t");
		 //System.out.println("Length:"+length);

		 //byte []buff=new byte[1024];
		 char []buff=new char[len];

		 br.read(buff);
		 //  for(char tmp:buff)
		 // {
		 // 	System.out.print(tmp);
		 // }
		 // System.out.println("End of buffer********************************************");

		 //br.mark(buff.length);
		 byte buffer[]=new byte[buff.length];
		 for(int i=0;i<buff.length;i++)
		 {
		 	buffer[i]=(byte)buff[i];
		 }

		 FileOutputStream fo = new FileOutputStream(name);

		 fo.write(buffer,0,len);
	    }
      }

      catch(Exception e)
       {
	   System.out.println(e);
       }	
       		System.out.println("Successfully Unpacked File");
        		    
     		   
        }
        });
	  
	}
}



class Pack extends JFrame
{
   Pack()
   {
   		JButton b,Back;
   		JTextField src,dest;
	    JLabel l1,l2;

		JFrame fr=new JFrame("Pack Window");
		
	    setLayout(new FlowLayout());
	    
	    JPanel p = new JPanel();

	    l1=new JLabel("Enter Folder");
	    l2=new JLabel("Enter File");

	    src=new JTextField("Folder name",16);
	    dest=new JTextField("File name",16);

	    b=new JButton("Packed it");
	    b.setBackground(new Color(146, 244, 66));

	    Back=new JButton("Back");
	    Back.setBackground(new Color(255, 0, 255));

      

	    p.add(l1);
	    p.add(src);
	    p.add(l2);
	    p.add(dest);
	    p.add(b);
	    p.add(Back);


        fr.add(p);


        
	    Back.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent ae)
        {   
        	fr.dispose();	    
     		First fst=new First();    
        }
        });


        b.addActionListener(new ActionListener()
		{
        public void actionPerformed(ActionEvent ae)
        {
        	JDialog d = new JDialog(fr, "Congrats"); 
  
            // create a label 
            JLabel l = new JLabel("Successfully Packed the File"); 
  
            d.add(l); 
  
            // setsize of dialog 
            d.setSize(200, 200); 
  
            // set visibility of dialog 
            d.setVisible(true); 
            d.setBackground(Color.green);
        String val1 = src.getText();
        String val2=dest.getText();   
    try{
		File folder = new File(val1);
		
		    
        File[] listOfFiles = folder.listFiles();


        FileOutputStream fo=new FileOutputStream(val2);

       for (int i = 0; i < listOfFiles.length; i++)
        {
             String s=(listOfFiles[i].getName()+" "+listOfFiles[i].length()+"\n");

            
		     byte b[]=s.getBytes();//converting string into byte array
		      
          
                if ((listOfFiles[i].isFile()))
                 {                
                  fo.write(b);                    
                 }

           	 String nm=listOfFiles[i].getName();
             FileInputStream fr=new FileInputStream(val1+nm);

                         
             byte buffer2[]=new byte[1024];
             
           
                  int length2=0;
                 	          		      
             	while ((length2 = fr.read(buffer2))>0) 
             	{		
               fo.write(buffer2,0,length2);
             	}
        }
    }
   catch(Exception e)
   {

   }
  
        System.out.println("Successfully Packed");
        
         	                     
        }
        });



		p.setBackground(new Color(255, 131, 6));
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		fr.setSize(600,400);

   }

}


class PackBack 
{
  PackBack()
  {
  }
  public void Packer(String str1,String str2)
  {
    try{
		File folder = new File(str1);
		
		    
        File[] listOfFiles = folder.listFiles();


        FileOutputStream fo=new FileOutputStream(str2);

       for (int i = 0; i < listOfFiles.length; i++)
        {
             String s=(listOfFiles[i].getName()+" "+listOfFiles[i].length()+"\n");

            
		     byte b[]=s.getBytes();//converting string into byte array
		      
          
                if ((listOfFiles[i].isFile()))
                 {                
                  fo.write(b);                    
                 }

           	 String nm=listOfFiles[i].getName();
             FileInputStream fr=new FileInputStream(str1+nm);

                         
             byte buffer2[]=new byte[1024];
             
           
                  int length2=0;
                 	          		      
             	while ((length2 = fr.read(buffer2))>0) 
             	{		
               fo.write(buffer2,0,length2);
             	}
        }
    }
   catch(Exception e)
   {

   }

  }
}
       






      














