package org.example;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.save();//сохранение в бд одного объекта класса Course
        service.read(11);//чтение из бд объекта с указанным ID
        service.update(1);//обновление объекта с указанным ID
        service.delete(22);//удаление объекта с указанным ID
    }
}