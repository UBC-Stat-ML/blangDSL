package blang.core;

public interface AnnealedFactor extends LogScaleFactor
{
  public RealVar getAnnealingParameter();
  public void setAnnealingParameter(RealVar param);
}
