package jetbrains.mps.lang.migration.runtime.base;

/*Generated by MPS */

import jetbrains.mps.refactoring.participant.RefactoringUI;
import java.util.List;
import jetbrains.mps.refactoring.participant.RefactoringParticipant;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import org.jetbrains.mps.openapi.util.ProgressMonitor;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.model.SearchTask;
import jetbrains.mps.refactoring.participant.RefactoringSession;

public class EmptyRefactoringUI implements RefactoringUI {
  private List<RefactoringParticipant.Option> mySelectedOptions;
  private _FunctionTypes._void_P1_E0<? super Runnable> myTaskRunner;
  public EmptyRefactoringUI(List<RefactoringParticipant.Option> selectedOptions, _FunctionTypes._void_P1_E0<? super Runnable> taskRunner) {
    mySelectedOptions = selectedOptions;
    myTaskRunner = taskRunner;
  }
  public void prepare(Runnable task) {
    task.run();
  }
  public void runSearch(final _FunctionTypes._void_P1_E0<? super ProgressMonitor> task) {
    task.invoke(new EmptyProgressMonitor());
  }
  public List<RefactoringParticipant.Option> selectParticipants(List<RefactoringParticipant.Option> availableOptions) {
    return (mySelectedOptions == null ? availableOptions : mySelectedOptions);
  }
  public void showRefactoringView(final Runnable task, String refactoringName, SearchResults searchResults, SearchTask searchTask, RefactoringSession refactoringSession) {
    myTaskRunner.invoke(task);
  }
}