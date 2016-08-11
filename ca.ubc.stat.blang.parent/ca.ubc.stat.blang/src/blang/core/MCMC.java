package blang.core;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflow;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

public class MCMC implements IWorkflow
{
  String test;

  @Override
  public void run(IWorkflowContext context)
  {
    System.out.println("running " + test);

  }
  
  public void addNIters(int nit) {
    this.test = test;
    System.out.println("ok");
  }
  
  public void addGoblin(String test) {
    this.test = test;
    System.out.println("ok");
  }

}
