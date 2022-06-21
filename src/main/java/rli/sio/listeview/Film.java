package rli.sio.listeview;

public class Film {
    private String _title;
    private Integer _cover;

    public Film(String title, Integer cover) {
        _title = title;
        _cover = cover;
    }

    public String getTitle() {
        return _title;
    }

    public Integer getCover() {
        return _cover;
    }
}