package dynamicc.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;
import org.jetbrains.mps.openapi.language.SProperty;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public final class RemoveReturnType_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public RemoveReturnType_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:b14ad5f6-81de-4f61-953c-64e0ee8829d9(dynamicc.intentions)", "2804056819677603068"));
  }
  @Override
  public String getPresentation() {
    return "RemoveReturnType";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SPropertyOperations.getBoolean(node, PROPS.hasReturnType$GLJn);
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Remove Return Type";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SPropertyOperations.assign(node, PROPS.hasReturnType$GLJn, false);
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return RemoveReturnType_Intention.this;
    }
  }

  private static final class PROPS {
    /*package*/ static final SProperty hasReturnType$GLJn = MetaAdapterFactory.getProperty(0xa6d9727f49824bf8L, 0xabdd083fea5126abL, 0x26ea02d22ae503deL, 0x26ea02d22ae5074dL, "hasReturnType");
  }
}
