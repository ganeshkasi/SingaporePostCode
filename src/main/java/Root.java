import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root {
    @JsonProperty("found")
    public int getFound() {
        return this.found;
    }

    public void setFound(int found) {
        this.found = found;
    }

    int found;

    @JsonProperty("totalNumPages")
    public int getTotalNumPages() {
        return this.totalNumPages;
    }

    public void setTotalNumPages(int totalNumPages) {
        this.totalNumPages = totalNumPages;
    }

    int totalNumPages;

    @JsonProperty("pageNum")
    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    int pageNum;

    @JsonProperty("results")
    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    List<Result> results;
}