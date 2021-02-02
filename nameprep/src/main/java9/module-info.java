module com.ongres.nameprep {
  requires transitive com.ongres.stringprep;
  provides com.ongres.stringprep.Profile with com.ongres.nameprep.Nameprep;
}