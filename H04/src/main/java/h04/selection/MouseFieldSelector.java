package h04.selection;

import fopbot.Field;
import fopbot.FieldClickEvent;
import fopbot.FieldClickListener;
import fopbot.World;

public class MouseFieldSelector implements FieldSelector, FieldClickListener {

    private FieldSelectionListener listener;

    public MouseFieldSelector() {
        World.addFieldClickListener(this);
    }

    @Override
    public void setFieldSelectionListener(FieldSelectionListener listener) {
        this.listener = listener;
    }

    private boolean clicked = false;
    private Field lastField;

    @Override
    public void onFieldClick(FieldClickEvent event) {
        if (clicked && event.getField() != lastField)
            listener.onFieldSelection(event.getField());

        lastField = event.getField();
        clicked = true;
    }

}
