package hexlet.code.util;

import hexlet.code.model.Task;
import hexlet.code.model.TaskStatus;
import hexlet.code.model.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import net.datafaker.Faker;
import org.instancio.Instancio;
import org.instancio.Model;
import org.instancio.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ModelGenerator {

    private Model<User> userModel;

    private Model<TaskStatus> taskStatusModel;

    private Model<Task> taskModel;

    @Autowired
    private Faker faker;

    @PostConstruct
    private void init() {
        userModel = Instancio.of(User.class)
                .ignore(Select.field(User::getId))
                .ignore(Select.field(User::getTasks))
                .supply(Select.field(User::getFirstName), () -> faker.name().firstName())
                .supply(Select.field(User::getLastName), () -> faker.name().lastName())
                .supply(Select.field(User::getEmail), () -> faker.internet().emailAddress())
                .supply(Select.field(User::getPasswordDigest), () -> faker.internet().password(3, 100))
                .toModel();

        taskStatusModel = Instancio.of(TaskStatus.class)
                .ignore(Select.field(TaskStatus::getId))
                .supply(Select.field(TaskStatus::getName), () -> faker.name().title())
                .supply(Select.field(TaskStatus::getSlug), () -> faker.internet().slug())
                .toModel();

        taskModel = Instancio.of(Task.class)
                .ignore(Select.field((Task::getId)))
                .ignore(Select.field(Task::getAssignee))
                .ignore(Select.field(Task::getTaskStatus))
                .supply(Select.field(Task::getName), () -> faker.name().title())
                .supply(Select.field(Task::getIndex), () -> faker.number().randomDigitNotZero())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().sentence())
                .toModel();

    }
}
