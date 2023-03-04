package tools;

import organizations.Address;
import organizations.Organization;

import java.io.File;
import java.util.Collections;
import java.util.Stack;

public class CommandList {
    Stack<Organization> stack;
    public CommandList(Stack<Organization> stack) {
        this.stack = stack;
    }

    public void help(){
        System.out.println("- `HELP`: вывести справку по доступным командам\n" +
                "- `INFO`: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "- `SHOW`: вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "- `ADD {element}`: добавить новый элемент в коллекцию\n" +
                "- `UPDATE id {element}`: обновить значение элемента коллекции, id которого равен заданному\n" +
                "- `REMOVE_BY_ID id`: удалить элемент из коллекции по его id\n" +
                "- `CLEAR`: очистить коллекцию\n" +
                "- `SAVE`: сохранить коллекцию в файл\n" +
                "- `EXECUTE_SCRIPT file_name`: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "- `EXIT`: завершить программу (без сохранения в файл)\n" +
                "- `REMOVE_LAST`: удалить последний элемент из коллекции\n" +
                "- `SHUFFLE`: перемешать элементы коллекции в случайном порядке\n" +
                "- `REMOVE_LOWER {element}`: удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "- `REMOVE_ALL_BY_POSTAL_ADDRESS postalAddress`: удалить из коллекции все элементы, значение поля postalAddress которого эквивалентно заданному\n" +
                "- `MIN_BY_FULL_NAME`: вывести любой объект из коллекции, значение поля fullName которого является минимальным\n" +
                "- `FILTER_GREATER_THAN_POSTAL_ADDRESS postalAddress`: вывести элементы, значение поля postalAddress которых больше заданного");
    }
    public void info(){
        stack.toString();

    }
    public void show(){
        for(Organization i : stack) {
            i.toString();
        }
    }
    public void add(Organization element){
        stack.push(element);
    }
    public void update(Organization element){
        //???
    }
    public void remove_by_id(int id){
        stack.removeElementAt(id);
    }
    public void clear(){
        stack.clear();
    }
    public void save(){
        //???
    }
    public void execute_script(File file_name){
        //???
    }
    public void exit(){
        //???
    }
    public void remove_last(){
        stack.pop();
    }
    public void shuffle(){
        Collections.shuffle(stack);
    }
    public void remove_lower(Organization element){
        //???
    }
    public void remove_all_by_postal_address(Address postaAddress){
        //???
    }
    public void min_by_full_name(){
        //???
    }
    public void filter_greater_than_postal_address(Address postalAddress){
        //???
    }
}
