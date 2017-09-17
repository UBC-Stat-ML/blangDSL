package blang.core;

public interface AnnealedFactor extends LogScaleFactor
{
  /*
   * We do not necessarily give access to the enclosed factor 
   * e.g. for cases such as subsampling where computing the 
   * enclosed would defy the point.
   */
  
  public RealVar getAnnealingParameter();
  public void setAnnealingParameter(RealVar param);
}
