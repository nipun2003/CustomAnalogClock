# CustomAnalogClock
It is simple and fully customizable analog clock view which gives you to set the analog clock in 
hour mode or minute mod.



# Minute mode view


![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/minute.png)


# Hour mode View


![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/hour.png)


# How to use
   ### Step1.Add the JitPack repository to your build file
   
        Add it in your root build.gradle at the end of repositories:
        
            maven { url 'https://jitpack.io' }
![maven](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/maven.png)

  ### Step 2. Add the dependency
  
        implementation 'com.github.nipun2003:CustomAnalogClock:0.1.0'
  ![dependency](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/dependencypic.png)

# XML Code

### sample code

      Add this code in your layout resource file
```
  <com.nipunapps.AnalogClockView.AnalogClockView
        android:id="@+id/anlogClockView"
        android:layout_width="270dp"
        android:layout_height="270dp"
        android:padding="20dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
        
  ```
  default view is seted in minute mode 
  
  
  # Some Important Attributes of xml
  
         User can add this attribute in view declare in layout to customize the view
  ```
        app:setHourMode="true"
        app:setDialColor="@color/purple_200"
        app:setHourHandColor="@color/design_default_color_primary"
        app:setMinuteHandColor="@color/black"
        app:setSecondHandColor="#09CEE8"
        app:setMainHourColor="@color/white"
        app:setSecondaryHourColor="#0F5F0A"
        
  ```
  
  # app:setHourMode
  
           setHourMode is an attribute of AnalogClockView declare in layout 
           which take a boolean input true of false.
           
           The default HourMode is false.
   ### if   app:setHourMode="true" view mode convert from minute view to Hour View
   ![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/hour.png)
   
### if   app:setHourMode="false"  or not declared this attribute in layout, view mode sets in minute mode
   ![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/minute.png)
          
  ### app:setDialColor
  
      This is also the view's attribute which take input a color and set the analog clock
      dial circle color.
      
  ### SetHourHandColor | MinuteHandColor | SecondHandColor
  
       This will set set the hour hand indicator color , Minute hand indicator color and 
          second hand indicator color respectively
       
 ### MainHourColor 
 
      This will set the text color of 3,6,9 and 12.
      
### SecondaryHourColor 

       This will set the text color of hour except 3,6,9 and 12.
       

### After Customization the view can change like this

   ![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/customize.png)
   
   
# Java Code

     You can start using the view in java by initialise view in your activity.
     
<span style="background-color: #000000">
     public class MainActivity extends AppCompatActivity {

     AnalogClockView analogClockView; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        analogClockView=findViewById(R.id.anlogClockView);
        }
</span>

      
  
          
        
