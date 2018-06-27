package com.example.android.background.utilities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;

import com.example.android.background.MainActivity;

/**
 * Utility class for creating hydration notifications
 */
public class NotificationUtils {
    private final static int WATER_REMINDER_PENDING_INTENT_ID = 232;

    public static void remindUserBeacauseCharging(Context context) {
        NotificationManager notificationManagerCompat = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(WATER_REMINDER_PENDING_INTENT_ID,
                    context.getString(android.R.string.main_notification_channel_name),
                    NotificationManagerCompat.IMPORTANCE_HIGH);
            notificationManagerCompat.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context.WATER_REMINDER_PENDING_INTENT_ID)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setLargeIcon(largeIcon(context))
                .setContentTitle(context.getString(android.R.string.cancel))
                .setContentText(context.getString(android.R.string.defaultVoiceMailAlphaTag))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(android.R.string.defaultVoiceMailAlphaTag)))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }

        notificationManagerCompat.notify(WATER_REMINDER_PENDING_INTENT_ID, notificationBuilder.build());
    }

    // should return a PendingIntent. This method will create the pending intent which will trigger when
    // the notification is pressed. This pending intent should open up the MainActivity.
    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, MainActivity.class);

        return PendingIntent.getActivity(
                context,
                WATER_REMINDER_PENDING_INTENT_ID,
                startActivityIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private static Bitmap largeIcon(Context context) {
        Resources res = context.getResources();
        Bitmap largeIcon = BitmapFactory.decodeResource(res, R.drawable.ic_local_dring_balck_24px);
        return largeIcon;
    }


}
