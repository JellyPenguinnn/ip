package chatbuddy.command;

import chatbuddy.exception.ChatBuddyException;
import chatbuddy.storage.Storage;
import chatbuddy.task.Task;
import chatbuddy.task.TaskList;
import chatbuddy.ui.Ui;

/**
 * Represents a command to unmark a task as done.
 */
public class UnmarkCommand extends Command {

    private int index;

    /**
     * Constructs an UnmarkCommand with the specified index of the task to be unmarked as done.
     *
     * @param index The index of the task to be unmarked as done.
     * @throws ChatBuddyException If the provided index is not a valid number.
     */
    public UnmarkCommand(String index) throws ChatBuddyException {
        try {
            this.index = Integer.parseInt(index) - 1;
        } catch (NumberFormatException e) {
            throw new ChatBuddyException("Invalid task number.");
        }
    }

    /**
     * Executes the unmark command, unmarking the task as done and updating the storage.
     *
     * @param tasks   The task list.
     * @param ui      The user interface to display the updated task status.
     * @param storage The storage to save the updated task list.
     * @throws ChatBuddyException If the task index is out of range.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ChatBuddyException {
        if (index >= tasks.size() || index < 0) {
            throw new ChatBuddyException("Task number out of range.");
        }
        Task task = tasks.getTask(index);
        task.unmarkAsDone();
        storage.saveTasks(tasks.getTasks());
        ui.showUnmarkTask(task);
        return ui.getOutput();
    }
}
