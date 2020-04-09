package se.mickelus.tetra.items.journal.gui.craft;

import se.mickelus.mgui.gui.GuiAttachment;
import se.mickelus.mgui.gui.GuiElement;
import se.mickelus.mgui.gui.GuiRect;
import se.mickelus.mgui.gui.animation.AnimationChain;
import se.mickelus.mgui.gui.animation.Applier;
import se.mickelus.mgui.gui.animation.KeyframeAnimation;
import se.mickelus.tetra.gui.GuiColors;

public class GuiJournalCross extends GuiElement {

    protected AnimationChain animation;
    private static final float targetOpacity = 0.2f;

    public GuiJournalCross(int x, int y, int delay) {
        super(x, y, 5, 5);

        setAttachment(GuiAttachment.middleCenter);

        addChild(new GuiRect(0, 0, 2, 1, GuiColors.normal).setAttachment(GuiAttachment.middleLeft));
        addChild(new GuiRect(0, 0, 3, 1, GuiColors.normal).setAttachment(GuiAttachment.middleRight));

        addChild(new GuiRect(0, 0, 1, 2, GuiColors.normal).setAttachment(GuiAttachment.topCenter));
        addChild(new GuiRect(0, 0, 1, 2, GuiColors.normal).setAttachment(GuiAttachment.bottomCenter));

        setOpacity(0);
        animation = new AnimationChain(
                new KeyframeAnimation(300, this).withDelay(delay).applyTo(new Applier.Opacity(targetOpacity * + 0.3f)),
                new KeyframeAnimation(200, this).applyTo(new Applier.Opacity(targetOpacity)));
    }

    public void animateOpen() {
        animation.stop();
        setOpacity(0);
        animation.start();
    }
}
