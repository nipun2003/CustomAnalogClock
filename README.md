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
          
  ### DialColor
  
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
      
  
          
        
