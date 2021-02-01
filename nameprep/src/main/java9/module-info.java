module com.ongres.nameprep {
  requires com.ongres.stringprep;
  provides com.ongres.stringprep.Profile with com.ongres.nameprep.Nameprep;
}