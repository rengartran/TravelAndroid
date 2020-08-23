package com.neptuunia.travel.utils;

import com.neptuunia.data.constant.TicketStatus;
import com.neptuunia.travel.R;

import android.content.Context;
import android.graphics.Color;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version StatusUtils, v 0.0.1 22/08/20 22.58 by Putra Nugraha
 */
public class StatusUtils {

    private StatusUtils() {
        // Prevent instantiation
    }

    public static int getBackgroundColor(@TicketStatus String status) {
        switch (status) {
            case TicketStatus.REJECTED:
                return R.color.lightRed;
            case TicketStatus.ACCEPTED:
                return R.color.lightGreen;
            default:
                return R.color.lightYellow;
        }
    }

    public static int getTextColor(Context context, @TicketStatus String status) {
        int colorId = getColorId(status);
        return Color.parseColor(context.getString(colorId));
    }

    private static int getColorId(@TicketStatus String status) {
        switch (status) {
            case TicketStatus.REJECTED:
                return R.color.darkRed;
            case TicketStatus.ACCEPTED:
                return R.color.darkGreen;
            default:
                return R.color.darkYellow;
        }
    }
}
