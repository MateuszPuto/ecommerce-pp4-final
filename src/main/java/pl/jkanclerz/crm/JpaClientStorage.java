package pl.jkanclerz.crm;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JpaClientStorage implements ClientRepository {

    public ClientRepository repository;

    JpaClientStorage(ClientRepository clientRepository) {
        this.repository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Client> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Client> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(String s) {
        repository.deleteById(s);
    }

    @Override
    public void delete(Client entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Client> entities) {

    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public <S extends Client> S save(S entity) {
        repository.save(entity);

        return entity;
    }

    @Override
    public <S extends Client> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Client> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Client> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Client> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Client> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Client getOne(String s) {
        return null;
    }

    @Override
    public Client getById(String s) {
        return repository.getById(s);
    }

    @Override
    public <S extends Client> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Client> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Client> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Client> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Client, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
