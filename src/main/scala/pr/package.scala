package pr

import workflows4s.wio.DraftWorkflowContext.*
import workflows4s.bpmn.BpmnRenderer
import org.camunda.bpm.model.bpmn.Bpmn
import java.io.File

val createPR = WIO.draft.signal()
val runPipeline = WIO.draft.step(error = "Critical issue")
val awaitReview = WIO.draft.step(error = "Rejected")

val mergePR = WIO.draft.signal()
val closePR = WIO.draft.signal()

val prWorkflow = (createPR >>>
  runPipeline >>>
  awaitReview >>>
  mergePR).handleErrorWith(
  closePR
)

@main
def bpmn =
  val bpmnModel =
    BpmnRenderer.renderWorkflow(prWorkflow.toProgress.toModel, "process")
  Bpmn.writeModelToFile(new File(s"pr-draft.bpmn").getAbsoluteFile, bpmnModel)
