package util;

import java.awt.*;

public class ColorUtil {
    public static Color blueColor = Color.decode("#3399ff");
    public static Color grayColor = Color.decode("#999999");
    static Color backgroundColor = Color.decode("#eeeeee");

    /**
     * @param per 根据进度显示不同的颜色
     * @return
     */
    public static Color getByPercentage(int per) {
        if (per > 100)
            per = 100;
        int r;
        int g;
        int b = 51;
        float rate = per / 100f;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;
        return new Color(r, g, b);
    }
}
