package com.wex.currencyconvert.domains.vos.reponses;


import java.util.List;

public class ExchangeRatesResponse {
    private List<ExchangeRateData> data;
    private Meta meta;
    private Links links;

    public List<ExchangeRateData> getData() {
        return data;
    }

    public void setData(List<ExchangeRateData> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public static class ExchangeRateData {
        private String record_date;
        private String country;
        private String currency;
        private String country_currency_desc;
        private String exchange_rate;
        private String effective_date;
        private String src_line_nbr;
        private String record_fiscal_year;
        private String record_fiscal_quarter;
        private String record_calendar_year;
        private String record_calendar_quarter;
        private String record_calendar_month;
        private String record_calendar_day;

        public String getRecord_date() {
            return record_date;
        }

        public void setRecord_date(String record_date) {
            this.record_date = record_date;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCountry_currency_desc() {
            return country_currency_desc;
        }

        public void setCountry_currency_desc(String country_currency_desc) {
            this.country_currency_desc = country_currency_desc;
        }

        public String getExchange_rate() {
            return exchange_rate;
        }

        public void setExchange_rate(String exchange_rate) {
            this.exchange_rate = exchange_rate;
        }

        public String getEffective_date() {
            return effective_date;
        }

        public void setEffective_date(String effective_date) {
            this.effective_date = effective_date;
        }

        public String getSrc_line_nbr() {
            return src_line_nbr;
        }

        public void setSrc_line_nbr(String src_line_nbr) {
            this.src_line_nbr = src_line_nbr;
        }

        public String getRecord_fiscal_year() {
            return record_fiscal_year;
        }

        public void setRecord_fiscal_year(String record_fiscal_year) {
            this.record_fiscal_year = record_fiscal_year;
        }

        public String getRecord_fiscal_quarter() {
            return record_fiscal_quarter;
        }

        public void setRecord_fiscal_quarter(String record_fiscal_quarter) {
            this.record_fiscal_quarter = record_fiscal_quarter;
        }

        public String getRecord_calendar_year() {
            return record_calendar_year;
        }

        public void setRecord_calendar_year(String record_calendar_year) {
            this.record_calendar_year = record_calendar_year;
        }

        public String getRecord_calendar_quarter() {
            return record_calendar_quarter;
        }

        public void setRecord_calendar_quarter(String record_calendar_quarter) {
            this.record_calendar_quarter = record_calendar_quarter;
        }

        public String getRecord_calendar_month() {
            return record_calendar_month;
        }

        public void setRecord_calendar_month(String record_calendar_month) {
            this.record_calendar_month = record_calendar_month;
        }

        public String getRecord_calendar_day() {
            return record_calendar_day;
        }

        public void setRecord_calendar_day(String record_calendar_day) {
            this.record_calendar_day = record_calendar_day;
        }
    }


    public static class Meta {
        private int count;
        private Labels labels;
        private DataTypes dataTypes;
        private DataFormats dataFormats;
        private int total_count;
        private int total_pages;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Labels getLabels() {
            return labels;
        }

        public void setLabels(Labels labels) {
            this.labels = labels;
        }

        public DataTypes getDataTypes() {
            return dataTypes;
        }

        public void setDataTypes(DataTypes dataTypes) {
            this.dataTypes = dataTypes;
        }

        public DataFormats getDataFormats() {
            return dataFormats;
        }

        public void setDataFormats(DataFormats dataFormats) {
            this.dataFormats = dataFormats;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }


        public static class Labels {
            private String record_date;
            private String country;
            private String currency;
            private String country_currency_desc;
            private String exchange_rate;
            private String effective_date;
            private String src_line_nbr;
            private String record_fiscal_year;
            private String record_fiscal_quarter;
            private String record_calendar_year;
            private String record_calendar_quarter;
            private String record_calendar_month;
            private String record_calendar_day;

            public String getRecord_date() {
                return record_date;
            }

            public void setRecord_date(String record_date) {
                this.record_date = record_date;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getCountry_currency_desc() {
                return country_currency_desc;
            }

            public void setCountry_currency_desc(String country_currency_desc) {
                this.country_currency_desc = country_currency_desc;
            }

            public String getExchange_rate() {
                return exchange_rate;
            }

            public void setExchange_rate(String exchange_rate) {
                this.exchange_rate = exchange_rate;
            }

            public String getEffective_date() {
                return effective_date;
            }

            public void setEffective_date(String effective_date) {
                this.effective_date = effective_date;
            }

            public String getSrc_line_nbr() {
                return src_line_nbr;
            }

            public void setSrc_line_nbr(String src_line_nbr) {
                this.src_line_nbr = src_line_nbr;
            }

            public String getRecord_fiscal_year() {
                return record_fiscal_year;
            }

            public void setRecord_fiscal_year(String record_fiscal_year) {
                this.record_fiscal_year = record_fiscal_year;
            }

            public String getRecord_fiscal_quarter() {
                return record_fiscal_quarter;
            }

            public void setRecord_fiscal_quarter(String record_fiscal_quarter) {
                this.record_fiscal_quarter = record_fiscal_quarter;
            }

            public String getRecord_calendar_year() {
                return record_calendar_year;
            }

            public void setRecord_calendar_year(String record_calendar_year) {
                this.record_calendar_year = record_calendar_year;
            }

            public String getRecord_calendar_quarter() {
                return record_calendar_quarter;
            }

            public void setRecord_calendar_quarter(String record_calendar_quarter) {
                this.record_calendar_quarter = record_calendar_quarter;
            }

            public String getRecord_calendar_month() {
                return record_calendar_month;
            }

            public void setRecord_calendar_month(String record_calendar_month) {
                this.record_calendar_month = record_calendar_month;
            }

            public String getRecord_calendar_day() {
                return record_calendar_day;
            }

            public void setRecord_calendar_day(String record_calendar_day) {
                this.record_calendar_day = record_calendar_day;
            }
        }

        public static class DataTypes {
            private String record_date;
            private String country;
            private String currency;
            private String country_currency_desc;
            private String exchange_rate;
            private String effective_date;
            private String src_line_nbr;
            private String record_fiscal_year;
            private String record_fiscal_quarter;
            private String record_calendar_year;
            private String record_calendar_quarter;
            private String record_calendar_month;
            private String record_calendar_day;

            public String getRecord_date() {
                return record_date;
            }

            public void setRecord_date(String record_date) {
                this.record_date = record_date;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getCountry_currency_desc() {
                return country_currency_desc;
            }

            public void setCountry_currency_desc(String country_currency_desc) {
                this.country_currency_desc = country_currency_desc;
            }

            public String getExchange_rate() {
                return exchange_rate;
            }

            public void setExchange_rate(String exchange_rate) {
                this.exchange_rate = exchange_rate;
            }

            public String getEffective_date() {
                return effective_date;
            }

            public void setEffective_date(String effective_date) {
                this.effective_date = effective_date;
            }

            public String getSrc_line_nbr() {
                return src_line_nbr;
            }

            public void setSrc_line_nbr(String src_line_nbr) {
                this.src_line_nbr = src_line_nbr;
            }

            public String getRecord_fiscal_year() {
                return record_fiscal_year;
            }

            public void setRecord_fiscal_year(String record_fiscal_year) {
                this.record_fiscal_year = record_fiscal_year;
            }

            public String getRecord_fiscal_quarter() {
                return record_fiscal_quarter;
            }

            public void setRecord_fiscal_quarter(String record_fiscal_quarter) {
                this.record_fiscal_quarter = record_fiscal_quarter;
            }

            public String getRecord_calendar_year() {
                return record_calendar_year;
            }

            public void setRecord_calendar_year(String record_calendar_year) {
                this.record_calendar_year = record_calendar_year;
            }

            public String getRecord_calendar_quarter() {
                return record_calendar_quarter;
            }

            public void setRecord_calendar_quarter(String record_calendar_quarter) {
                this.record_calendar_quarter = record_calendar_quarter;
            }

            public String getRecord_calendar_month() {
                return record_calendar_month;
            }

            public void setRecord_calendar_month(String record_calendar_month) {
                this.record_calendar_month = record_calendar_month;
            }

            public String getRecord_calendar_day() {
                return record_calendar_day;
            }

            public void setRecord_calendar_day(String record_calendar_day) {
                this.record_calendar_day = record_calendar_day;
            }
        }

        public static class DataFormats {
            private String record_date;
            private String country;
            private String currency;
            private String country_currency_desc;
            private String exchange_rate;
            private String effective_date;
            private String src_line_nbr;
            private String record_fiscal_year;
            private String record_fiscal_quarter;
            private String record_calendar_year;
            private String record_calendar_quarter;
            private String record_calendar_month;
            private String record_calendar_day;

            public String getRecord_date() {
                return record_date;
            }

            public void setRecord_date(String record_date) {
                this.record_date = record_date;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getCountry_currency_desc() {
                return country_currency_desc;
            }

            public void setCountry_currency_desc(String country_currency_desc) {
                this.country_currency_desc = country_currency_desc;
            }

            public String getExchange_rate() {
                return exchange_rate;
            }

            public void setExchange_rate(String exchange_rate) {
                this.exchange_rate = exchange_rate;
            }

            public String getEffective_date() {
                return effective_date;
            }

            public void setEffective_date(String effective_date) {
                this.effective_date = effective_date;
            }

            public String getSrc_line_nbr() {
                return src_line_nbr;
            }

            public void setSrc_line_nbr(String src_line_nbr) {
                this.src_line_nbr = src_line_nbr;
            }

            public String getRecord_fiscal_year() {
                return record_fiscal_year;
            }

            public void setRecord_fiscal_year(String record_fiscal_year) {
                this.record_fiscal_year = record_fiscal_year;
            }

            public String getRecord_fiscal_quarter() {
                return record_fiscal_quarter;
            }

            public void setRecord_fiscal_quarter(String record_fiscal_quarter) {
                this.record_fiscal_quarter = record_fiscal_quarter;
            }

            public String getRecord_calendar_year() {
                return record_calendar_year;
            }

            public void setRecord_calendar_year(String record_calendar_year) {
                this.record_calendar_year = record_calendar_year;
            }

            public String getRecord_calendar_quarter() {
                return record_calendar_quarter;
            }

            public void setRecord_calendar_quarter(String record_calendar_quarter) {
                this.record_calendar_quarter = record_calendar_quarter;
            }

            public String getRecord_calendar_month() {
                return record_calendar_month;
            }

            public void setRecord_calendar_month(String record_calendar_month) {
                this.record_calendar_month = record_calendar_month;
            }

            public String getRecord_calendar_day() {
                return record_calendar_day;
            }

            public void setRecord_calendar_day(String record_calendar_day) {
                this.record_calendar_day = record_calendar_day;
            }
        }
    }

    public static class Links {
        private String self;
        private String first;
        private String prev;
        private String next;
        private String last;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }
    }
}
