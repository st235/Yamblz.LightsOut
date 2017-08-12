package xyz.javablog.session;

import xyz.javablog.common.fields.Field;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;

/**
 * Created by alexander on 12/08/2017.
 */

public interface Session {
    Field init(Size size);

    Field getOrigin();
    Field clickForward(Point point);
    Field clickBackward(int steps);

    boolean isInit();
}
