public class MoviesFactory implements GeneralFactory{
    @Override
    public General createInstance() {
        return new Movies();
    }
}
