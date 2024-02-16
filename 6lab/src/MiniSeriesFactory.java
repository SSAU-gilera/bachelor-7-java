public class MiniSeriesFactory implements GeneralFactory{
    @Override
    public General createInstance() {
        return new MiniSeries();
    }
}
