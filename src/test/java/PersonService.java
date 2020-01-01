public class PersonService {
    private PersonDao personDao;

    PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void update(int id, String name) {
        personDao.update(new Person(id, name));
    }
}