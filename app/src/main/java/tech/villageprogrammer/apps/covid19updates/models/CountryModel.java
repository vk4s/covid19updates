package tech.villageprogrammer.apps.covid19updates.models;

public class CountryModel {
    private String flag, countryName, cases, todayCases, deaths,
            todayDeaths, recovered,todayRecovered, active, critical, continent, casesPerMillion;

    public CountryModel() {
    }

    public String getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public String getCasesPerMillion() {
        return casesPerMillion;
    }

    public void setCasesPerMillion(String casesPerMillion) {
        this.casesPerMillion = casesPerMillion;
    }

    public CountryModel(String flag, String countryName, String cases,
                        String todayCases, String deaths, String todayDeaths,
                        String recovered, String todayRecovered, String active, String critical,
                        String continent, String casesPerMillion) {
        this.flag = flag;
        this.countryName = countryName;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.continent = continent;
        this.casesPerMillion = casesPerMillion;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
