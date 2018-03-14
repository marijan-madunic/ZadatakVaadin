package com.example.ZadatakVaadin;

public class City {
	
	private Long id;
    private String cityName;

    public City(Long id, String cityName) {
        this.id = id;
        this.cityName = cityName;       
    }
    
    
	public Long getCityId() {
		return id;
	}

	public void setCityId(Long id) {
		this.id = id;
	}
	
	/**
	 * Get the value of cityName
	 *
	 * @return the value of cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * Set the value of cityName
	 *
	 * @param cityName
	 *            new value of lastName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
