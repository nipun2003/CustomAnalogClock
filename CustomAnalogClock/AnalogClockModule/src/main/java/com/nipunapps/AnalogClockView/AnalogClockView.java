package com.nipunapps.AnalogClockView;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;



import java.util.Calendar;

public class AnalogClockView extends View {
    Context context;
    private int MAX_HEIGHT_WIDTH = 1080;
    private int height, width = 0;
    private int padding = 0;
    private int handLength, hourhandLength, minuteHandLength = 0;
    private int radius = 0;
    private int numeralStart = 0;
    private int circleStroke = 0;
    private int numeralStroke = 0;
    private int handStroke = 0;
    private Paint paint = new Paint();
    private boolean isInit;
    private Rect rect = new Rect();
    private int[] HOUR={1,2,3,4,5,6,7,8,9,10,11,12};

    // Variables which can be set by users
    private int dialCircleColor, hourHandColor, minuteHandColor, secondHandColor,mainHourColor,secondaryHourColor;

/*    mainHourColor--> the color of hour 3,6,9,12
      secondaryHourColor--> the color of rest hour
 */

    private boolean ishour = false;

    public AnalogClockView(Context context) {
        super(context);
        this.context = context;
    }

    public AnalogClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

//        getting the input from xml tags
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AnalogClockView, 0, 0);
        try {
            dialCircleColor = (int) a.getColor(R.styleable.AnalogClockView_setDialColor, Color.parseColor("#ECF1F8"));
            hourHandColor = (int) a.getColor(R.styleable.AnalogClockView_setHourHandColor, Color.parseColor("#FFC03D"));
            minuteHandColor = (int) a.getColor(R.styleable.AnalogClockView_setMinuteHandColor, Color.parseColor("#351C35"));
            secondHandColor = (int) a.getColor(R.styleable.AnalogClockView_setSecondHandColor, Color.parseColor("#FF2525"));
            ishour=(boolean)a.getBoolean(R.styleable.AnalogClockView_setHourMode,false);
            mainHourColor=(int)a.getColor(R.styleable.AnalogClockView_setMainHourColor,Color.BLACK);
            secondaryHourColor=(int)a.getColor(R.styleable.AnalogClockView_setSecondaryHourColor,Color.rgb(140, 140, 115));
        } finally {
            a.recycle();
        }
    }

    public AnalogClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initClock() {
        /* This method is used for
         * initialising the clock view
         */
//        Initialising the clock
        height = getHeight();
        width = getWidth();
//        Default padding
        int min = Math.min(height, width);
        padding = (Math.max(height, width)) / 16;
        numeralStart = min / 33;
        radius = min / 2 - padding;

//        Defining the Strokes of various views
        circleStroke = (int) ((min) / 8.1);
        numeralStroke = (int) ((min) / 81);
        handStroke = (int) ((min) / 54);

//        Defining the length truncation of hour,minute and second
        handLength = min / 20;
        hourhandLength = min / 6;
        minuteHandLength = min / 15;
        isInit = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!isInit) {
            /* If clock is not initialised we have
             * to initialise the clock.
             */
            initClock();
        }
        /* For an analog clock we have to draw
         * a circle which is called dial circle.
         */
        drawCircle(canvas);

        /* Numeral are the indicator of time
         * in clock which is 1 to 12 for hour mode
         * and 1 to 60 in the minute mode.
         */
        drawNumeral(canvas);

        /* Hands are like a pointer which
         * is used for pointing the time so
         * for knowing the current time we must draw
         * 3 hand the smallest one is for hour, middle for minute
         * and the biggest one for minute.
         */
        drawHands(canvas);

        /* We draw a circle at the center so that
         * all the 3 hands looks they are joined in
         * a single thing.
         */
        drawCenter(canvas);

        postInvalidateDelayed(500);
        invalidate();
    }

    private void drawHand(Canvas canvas, double loc, boolean isHour, boolean isMinute) {
        /* The angle is used for locating the location
         * for the hands.
         */
        double angle = Math.PI * loc / 30 - Math.PI / 2;

        // Setting up the hands stroke width
        paint.setStrokeWidth(handStroke);

        /* For showing some reverse legth of hand
         * we use reverse hand length.
         */
        int reverseHandlength = Math.min(height, width) / 17;
        paint.setStrokeCap(Paint.Cap.ROUND);
        int handRadius = 0;
        if (isHour) {
            handRadius = radius - handLength - hourhandLength;
            paint.setColor(hourHandColor);
        } else if (isMinute) {
            handRadius = radius - handLength - minuteHandLength;
            paint.setColor(minuteHandColor);
        } else {
            handRadius = radius - handLength;
            paint.setColor(secondHandColor);
        }
        canvas.drawLine((width / 2), (height / 2),
                (float) (width / 2 + Math.cos(angle) * handRadius),
                (float) (height / 2 + Math.sin(angle) * handRadius), paint);
        canvas.drawLine((width / 2), (height / 2),
                (float) (width / 2 - Math.cos(angle) * reverseHandlength),
                (float) (height / 2 - Math.sin(angle) * reverseHandlength), paint);
    }

    private void drawHands(Canvas canvas) {
//        This method is used for draw hour,minute and second hand

        paint.setStrokeWidth(handStroke);
        Calendar c = Calendar.getInstance();
        float hour = c.get(Calendar.HOUR_OF_DAY);
        hour = hour > 12 ? hour - 12 : hour;
        drawHand(canvas, (hour + c.get(Calendar.MINUTE) / 60) * 5f, true, false);
        drawHand(canvas, c.get(Calendar.MINUTE), false, true);
        drawHand(canvas, c.get(Calendar.SECOND), false, false);
    }

    private void drawNumeral(Canvas canvas) {
//        This method draw the 12 hour or 60 minutes indicator

        int handRadius = radius - handLength + numeralStroke;
        int endPos = radius + numeralStroke;
        paint.setColor(Color.WHITE);
        if(ishour){
            for(int num:HOUR){
                int numbStroke=numeralStroke/2;
                paint.setStrokeWidth(numbStroke);
                paint.setTextSize(numeralStroke*5.0f);
                String tmp=String.valueOf(num);
                paint.getTextBounds(tmp,0,tmp.length(),rect);
                double angle=Math.PI/6*(num-3);
                if(num%3==0){
                    paint.setColor(mainHourColor);
                }
                else {
                    paint.setColor(secondaryHourColor);
                }
                int x = (int) (width / 2 + Math.cos(angle) * radius - rect.width() / 2);
                int y = (int) (height / 2 + Math.sin(angle) * radius + rect.height() / 2);
                canvas.drawText(tmp,x,y,paint);
            }
        }
        else {
            for (int i = 1; i <= 60; i++) {
                paint.setStrokeWidth(numeralStroke);
                String tmp = String.valueOf(i);
                double angle = Math.PI / 30 * (i - 15);
                if (i % 15 != 0 && i % 5 == 0) {
                    paint.setColor(secondaryHourColor);
                } else if (i % 15 == 0) {
                    paint.setColor(mainHourColor);
                } else {
                    paint.setColor(Color.WHITE);
                }
                if (i == 60) {
                    handRadius = radius - handLength + numeralStroke;
                    endPos = endPos + (Math.min(height, width) / 55);
                }
                paint.getTextBounds(tmp, 0, tmp.length(), rect);
                int x = (int) (width / 2 + Math.cos(angle) * radius - rect.width() / 2);
                int y = (int) (height / 2 + Math.sin(angle) * radius + rect.height() / 2);
                canvas.drawLine((float) (width / 2 + Math.cos(angle) * handRadius),
                        (float) (height / 2 + Math.sin(angle) * handRadius),
                        (float) (width / 2 + Math.cos(angle) * endPos),
                        (float) (height / 2 + Math.sin(angle) * endPos), paint);

            }
        }
    }

    private void drawCenter(Canvas canvas) {
//        This method draw the center of circle

        paint.setStrokeWidth(numeralStroke);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(secondHandColor);
        canvas.drawCircle(width / 2, height / 2, height / 40, paint);
    }

    private void drawCircle(Canvas canvas) {
//        This method draw the dial of analog clock

        paint.reset();
        paint.setColor(dialCircleColor);
        paint.setStrokeWidth(circleStroke);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawCircle(width / 2, height / 2, radius, paint);
    }


    /* The getter and setter of all attributes
    which is defined by user in xml tags
     */

    public int getHourHandColor() {
        return hourHandColor;
    }

    public void setHourHandColor(int hourHandColor) {
        this.hourHandColor = hourHandColor;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
        invalidate();
        requestLayout();
    }

    public int getDialCircleColor() {
        return dialCircleColor;
    }

    public void setDialCircleColor(int dialCircleColor) {
        this.dialCircleColor = dialCircleColor;
        invalidate();
        requestLayout();
    }
    public int getMinuteHandColor() {
        return minuteHandColor;
    }

    public void setMinuteHandColor(int minuteHandColor) {
        this.minuteHandColor = minuteHandColor;
        invalidate();
        requestLayout();
    }

    public int getSecondHandColor() {
        return secondHandColor;
    }

    public void setSecondHandColor(int secondHandColor) {
        this.secondHandColor = secondHandColor;
        invalidate();
        requestLayout();
    }

    public boolean isIshour() {
        return ishour;
    }

    public void setIshour(boolean ishour) {
        this.ishour = ishour;
        invalidate();
        requestLayout();
    }

    public int getMainHourColor() {
        return mainHourColor;
    }

    public void setMainHourColor(int mainHourColor) {
        this.mainHourColor = mainHourColor;
        invalidate();
        requestLayout();
    }

    public int getSecondaryHourColor() {
        return secondaryHourColor;
    }

    public void setSecondaryHourColor(int secondaryHourColor) {
        this.secondaryHourColor = secondaryHourColor;
        invalidate();
        requestLayout();
    }
}
