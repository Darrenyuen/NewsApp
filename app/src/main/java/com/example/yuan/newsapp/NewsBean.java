package com.example.yuan.newsapp;

import java.util.List;

public class NewsBean {

    private String reason;
    private int error_code;
    private List<Result> results;

    NewsBean(String reason, int error_code, List<Result> results) {
        this.reason = reason;
        this.error_code = error_code;
        this.results = results;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    static class Result {
        String stat;
        List<Data> list;
        Result(String stat, List<Data> list) {
            this.stat = stat;
            this.list = list;
        }
    }
}
