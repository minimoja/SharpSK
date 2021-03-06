package me.sharpjaws.sharpSK;

import org.bukkit.Bukkit;

import me.sharpjaws.sharpSK.Events.EvtTimerComplete;
import me.sharpjaws.sharpSK.Events.EvtTimerTick;

public class TimerHandler implements Runnable {

	// Class implemented as a workaround for avoiding async problems in timers that
	// are running synchronously.
	String timername;
	int timercountdown;
	int timert;
	int type;

	public TimerHandler(String Tname, int Countdown, int type, int timertype) {
		timername = Tname;
		timert = timertype;
		timercountdown = Countdown;
		this.type = type;

	}

	@Override
	public void run() {
		if (type == 1) {
			EvtTimerTick ev1 = new EvtTimerTick(timername, timercountdown, timert);
			Bukkit.getPluginManager().callEvent(ev1);

		} else if (type == 2) {
			EvtTimerComplete ev2 = new EvtTimerComplete(timername);
			Bukkit.getPluginManager().callEvent(ev2);

		}

	}

}
