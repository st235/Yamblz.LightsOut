package xyz.javablog.session;

import com.sun.istack.internal.NotNull;

import xyz.javablog.common.fields.Field;
import xyz.javablog.common.points.Point;
import xyz.javablog.common.sizes.Size;

/**
 * Created by alexander on 12/08/2017.
 */

public interface Session {
    Field init(@NotNull Size size);

    Field getOrigin();
    Field clickForward(@NotNull Point point);
    Field clickBackward(int steps);

    boolean isInit();
}
