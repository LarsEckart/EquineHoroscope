package com.gdinwiddie.equinehoroscope;

import com.gdinwiddie.equinehoroscope.mumbler.MumblerAdapter;

public class CrystalBall {

	private HoroscopeProvider horoscopeProvider;

	CrystalBall(HoroscopeProvider horoscopeProvider) {
		this.horoscopeProvider = horoscopeProvider;
	}

	CrystalBall() {
		this(new CachingHoroscopeProvider(MumblerAdapter.instance(), new InMemoryHoroscopeCache()));
	}

	public static CrystalBall instance() {
		return new CrystalBall();
	}

	public String fetchHoroscope(String horse, String effectiveDate) {
		return horoscopeProvider.horoscopeFor(horse, effectiveDate);
	}

}
