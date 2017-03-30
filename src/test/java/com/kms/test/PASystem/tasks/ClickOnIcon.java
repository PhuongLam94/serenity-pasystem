package com.kms.test.PASystem.tasks;

import com.kms.test.PASystem.questions.IconBackgroundImage;
import com.kms.test.PASystem.questions.TargetVisibility;
import com.kms.test.PASystem.ui.KMSCoreValueSection;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClickOnIcon implements Task{
	private WebElementFacade frame;
	private int index;
	private boolean isPlusIcon;
	
	@Step("{0} clicks open/close icon on section number #index")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(KMSCoreValueSection.ICON.resolveAllFor(actor).get(index)));
			frame.waitForCondition().until(
					isPlusIcon?ExpectedConditions.visibilityOf(frame)
							: ExpectedConditions.invisibilityOfAllElements(Arrays.asList((WebElement) frame))
					);
		
		actor.should(seeThat(TargetVisibility.of(frame), equalTo(isPlusIcon)));
		actor.should(seeThat(IconBackgroundImage.indexOf(index), 
				containsString(isPlusIcon?Global.MINUS_ICON:Global.PLUS_ICON)));
	}

	protected ClickOnIcon(WebElementFacade frame, int index, boolean isPlusIcon) {
		super();
		this.frame = frame;
		this.index = index;
		this.isPlusIcon = isPlusIcon;
	}

	public static ClickOnIcon ofFrameWithPositionAndIsPlusIcon(WebElementFacade frame, int index, boolean isPlusIcon) {
		// TODO Auto-generated method stub
		return Instrumented.instanceOf(ClickOnIcon.class)
				.withProperties(frame, index, isPlusIcon);
	}

}
