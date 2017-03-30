package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.kms.test.PASystem.questions.DateString;
import com.kms.test.PASystem.ui.DateSelectPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SelectDate implements Task{

	Target input;
	Target img;
	String value;
	protected SelectDate(Target input, Target img, String value) {
		super();
		this.input = input;
		this.img = img;
		this.value = value;
	}

	public static Performable withInputImgAndValue(Target input, Target img, String value) {
		return Instrumented.instanceOf(SelectDate.class)
				.withProperties(input, img, value);
	}
	@Step("{0} selects date")
	@Override
	public <T extends Actor> void performAs(T actor) {
		DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat monthInShortFormatter = new SimpleDateFormat("MMM");
		DateFormat yearFormatter = new SimpleDateFormat("yyyy");
		//DateFormat dateFormatter = new SimpleDateFormat("dd");
		
		Date date=new Date();
		try {
			date = parser.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		actor.attemptsTo(Click.on(img));
		actor.attemptsTo(
				Instrumented.instanceOf(SelectByVisibleTextFromTarget.class)
				.withProperties(DateSelectPage.YEAR_SELECT, yearFormatter.format(date)));
		actor.attemptsTo(Instrumented.instanceOf(SelectByVisibleTextFromTarget.class)
				.withProperties(DateSelectPage.MONTH_SELECT, monthInShortFormatter.format(date)));
		actor.attemptsTo(
				Click.on(DateSelectPage.GET_DATE_LINK(cal.get(Calendar.DATE)))
		);
		actor.should(seeThat(DateString.of(input), equalTo(value)));
		
	}

}
