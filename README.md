# CustomAnalogClock
It is simple and fully customize analog clock view which gives you to set the analog clock in 
hour mode or minute mod.



# Minute mode view


![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/minute.png)


# Hour mode View


![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/hour.png)


# Usage
  For using this view you just need to add [AnalogClockView](https://github.com/nipun2003/CustomAnalogClock/blob/main/AnalogClock/app/src/main/java/com/nipunapps/AnalogClockView/AnalogClockView.java) class in your main project
  
  
  
      Important --> If the class show some error you just need to import your project R
      and change the package name with your package name
  
  And the [attrs.xml](https://github.com/nipun2003/CustomAnalogClock/blob/main/AnalogClock/app/src/main/res/values/attrs.xml) in your res/values folder.
  
  Than after you just need to implement the code below in your layout file.

# Sample code 
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
        
        
        Important --> You just write your project package name instead of my
                      in attribute declaration 
        
  ```
  
  
  # Some Important Attributes 
  
  ```
        app:setHourMode="true"
        app:setDialColor="@color/purple_200"
        app:setHourHandColor="@color/design_default_color_primary"
        app:setMinuteHandColor="@color/black"
        app:setSecondHandColor="#09CEE8"
        app:setMainHourColor="@color/white"
        app:setSecondaryHourColor="#0F5F0A"
        
  ```
  
  # HourMode
   ### if HourMode is seted true view look like this 
   ![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/hour.png)
   
   ### if HourMode is seted false or not declared view look like this
   ![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/minute.png)
          
  ### DialCircleColor
  
      This will set the analog clock main circle color
      
  ### SetHourHandColor | MinuteHandColor | SecondHandColor
  
       This will set set the hour indicator color , Minute indicator color and 
          second indicator color respectively
       
 ### MainHourColor 
 
      This will set the text color of 3,6,9 and 12 and also their indicator
      
### SecondaryHourColor 

       This will set the text color of rest hour and their indicator
       

### After Customization the view can change like this

   ![AnalogClock](https://github.com/nipun2003/CustomAnalogClock/blob/main/analog%20clock%20pic/customize.png)
   
   
# Java Code

      you can set the all attributes by runtime in java by creating instance of 
      the AnalogClockView class
      
  ### setter of java
      
        .setHourHandColor(int color)
        
        .setDialCircleColor(int color)
        
        .setMinuteHandColor(int color)
        
        .setSecondHandColor(int color)
        
        .setIsHour(boolean isHour) // If true it will show Hour Mode View else it will show Minute Mode view
        
        .setMainHourColor(int color)
        
        .setSecondaryHourColor(int color)
      
  
          
        
