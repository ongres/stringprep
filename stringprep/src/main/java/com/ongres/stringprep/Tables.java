/*
 * Copyright (c) 2019 OnGres, Inc.
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.ongres.stringprep;

// AUTO-GENERATED FILE - DO NOT EDIT!

/**
 * Expose tables parsed from the StringPrep RFC-3454.
 */
public final class Tables {

  private Tables() {
    throw new AssertionError();
  }

  /**
   * Unassigned code points in Unicode 3.2.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is
   *         "Unassigned code points in Unicode 3.2".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-A.1">RFC 3454, Appendix A.1</a>
   */
  public static boolean unassignedCodePoints(int codePoint) {
    return codePoint == 0x0221
        || (codePoint >= 0x0234 && codePoint <= 0x024F)
        || (codePoint >= 0x02AE && codePoint <= 0x02AF)
        || (codePoint >= 0x02EF && codePoint <= 0x02FF)
        || (codePoint >= 0x0350 && codePoint <= 0x035F)
        || (codePoint >= 0x0370 && codePoint <= 0x0373)
        || (codePoint >= 0x0376 && codePoint <= 0x0379)
        || (codePoint >= 0x037B && codePoint <= 0x037D)
        || (codePoint >= 0x037F && codePoint <= 0x0383)
        || codePoint == 0x038B
        || codePoint == 0x038D
        || codePoint == 0x03A2
        || codePoint == 0x03CF
        || (codePoint >= 0x03F7 && codePoint <= 0x03FF)
        || codePoint == 0x0487
        || codePoint == 0x04CF
        || (codePoint >= 0x04F6 && codePoint <= 0x04F7)
        || (codePoint >= 0x04FA && codePoint <= 0x04FF)
        || (codePoint >= 0x0510 && codePoint <= 0x0530)
        || (codePoint >= 0x0557 && codePoint <= 0x0558)
        || codePoint == 0x0560
        || codePoint == 0x0588
        || (codePoint >= 0x058B && codePoint <= 0x0590)
        || codePoint == 0x05A2
        || codePoint == 0x05BA
        || (codePoint >= 0x05C5 && codePoint <= 0x05CF)
        || (codePoint >= 0x05EB && codePoint <= 0x05EF)
        || (codePoint >= 0x05F5 && codePoint <= 0x060B)
        || (codePoint >= 0x060D && codePoint <= 0x061A)
        || (codePoint >= 0x061C && codePoint <= 0x061E)
        || codePoint == 0x0620
        || (codePoint >= 0x063B && codePoint <= 0x063F)
        || (codePoint >= 0x0656 && codePoint <= 0x065F)
        || (codePoint >= 0x06EE && codePoint <= 0x06EF)
        || codePoint == 0x06FF
        || codePoint == 0x070E
        || (codePoint >= 0x072D && codePoint <= 0x072F)
        || (codePoint >= 0x074B && codePoint <= 0x077F)
        || (codePoint >= 0x07B2 && codePoint <= 0x0900)
        || codePoint == 0x0904
        || (codePoint >= 0x093A && codePoint <= 0x093B)
        || (codePoint >= 0x094E && codePoint <= 0x094F)
        || (codePoint >= 0x0955 && codePoint <= 0x0957)
        || (codePoint >= 0x0971 && codePoint <= 0x0980)
        || codePoint == 0x0984
        || (codePoint >= 0x098D && codePoint <= 0x098E)
        || (codePoint >= 0x0991 && codePoint <= 0x0992)
        || codePoint == 0x09A9
        || codePoint == 0x09B1
        || (codePoint >= 0x09B3 && codePoint <= 0x09B5)
        || (codePoint >= 0x09BA && codePoint <= 0x09BB)
        || codePoint == 0x09BD
        || (codePoint >= 0x09C5 && codePoint <= 0x09C6)
        || (codePoint >= 0x09C9 && codePoint <= 0x09CA)
        || (codePoint >= 0x09CE && codePoint <= 0x09D6)
        || (codePoint >= 0x09D8 && codePoint <= 0x09DB)
        || codePoint == 0x09DE
        || (codePoint >= 0x09E4 && codePoint <= 0x09E5)
        || (codePoint >= 0x09FB && codePoint <= 0x0A01)
        || (codePoint >= 0x0A03 && codePoint <= 0x0A04)
        || (codePoint >= 0x0A0B && codePoint <= 0x0A0E)
        || (codePoint >= 0x0A11 && codePoint <= 0x0A12)
        || codePoint == 0x0A29
        || codePoint == 0x0A31
        || codePoint == 0x0A34
        || codePoint == 0x0A37
        || (codePoint >= 0x0A3A && codePoint <= 0x0A3B)
        || codePoint == 0x0A3D
        || (codePoint >= 0x0A43 && codePoint <= 0x0A46)
        || (codePoint >= 0x0A49 && codePoint <= 0x0A4A)
        || (codePoint >= 0x0A4E && codePoint <= 0x0A58)
        || codePoint == 0x0A5D
        || (codePoint >= 0x0A5F && codePoint <= 0x0A65)
        || (codePoint >= 0x0A75 && codePoint <= 0x0A80)
        || codePoint == 0x0A84
        || codePoint == 0x0A8C
        || codePoint == 0x0A8E
        || codePoint == 0x0A92
        || codePoint == 0x0AA9
        || codePoint == 0x0AB1
        || codePoint == 0x0AB4
        || (codePoint >= 0x0ABA && codePoint <= 0x0ABB)
        || codePoint == 0x0AC6
        || codePoint == 0x0ACA
        || (codePoint >= 0x0ACE && codePoint <= 0x0ACF)
        || (codePoint >= 0x0AD1 && codePoint <= 0x0ADF)
        || (codePoint >= 0x0AE1 && codePoint <= 0x0AE5)
        || (codePoint >= 0x0AF0 && codePoint <= 0x0B00)
        || codePoint == 0x0B04
        || (codePoint >= 0x0B0D && codePoint <= 0x0B0E)
        || (codePoint >= 0x0B11 && codePoint <= 0x0B12)
        || codePoint == 0x0B29
        || codePoint == 0x0B31
        || (codePoint >= 0x0B34 && codePoint <= 0x0B35)
        || (codePoint >= 0x0B3A && codePoint <= 0x0B3B)
        || (codePoint >= 0x0B44 && codePoint <= 0x0B46)
        || (codePoint >= 0x0B49 && codePoint <= 0x0B4A)
        || (codePoint >= 0x0B4E && codePoint <= 0x0B55)
        || (codePoint >= 0x0B58 && codePoint <= 0x0B5B)
        || codePoint == 0x0B5E
        || (codePoint >= 0x0B62 && codePoint <= 0x0B65)
        || (codePoint >= 0x0B71 && codePoint <= 0x0B81)
        || codePoint == 0x0B84
        || (codePoint >= 0x0B8B && codePoint <= 0x0B8D)
        || codePoint == 0x0B91
        || (codePoint >= 0x0B96 && codePoint <= 0x0B98)
        || codePoint == 0x0B9B
        || codePoint == 0x0B9D
        || (codePoint >= 0x0BA0 && codePoint <= 0x0BA2)
        || (codePoint >= 0x0BA5 && codePoint <= 0x0BA7)
        || (codePoint >= 0x0BAB && codePoint <= 0x0BAD)
        || codePoint == 0x0BB6
        || (codePoint >= 0x0BBA && codePoint <= 0x0BBD)
        || (codePoint >= 0x0BC3 && codePoint <= 0x0BC5)
        || codePoint == 0x0BC9
        || (codePoint >= 0x0BCE && codePoint <= 0x0BD6)
        || (codePoint >= 0x0BD8 && codePoint <= 0x0BE6)
        || (codePoint >= 0x0BF3 && codePoint <= 0x0C00)
        || codePoint == 0x0C04
        || codePoint == 0x0C0D
        || codePoint == 0x0C11
        || codePoint == 0x0C29
        || codePoint == 0x0C34
        || (codePoint >= 0x0C3A && codePoint <= 0x0C3D)
        || codePoint == 0x0C45
        || codePoint == 0x0C49
        || (codePoint >= 0x0C4E && codePoint <= 0x0C54)
        || (codePoint >= 0x0C57 && codePoint <= 0x0C5F)
        || (codePoint >= 0x0C62 && codePoint <= 0x0C65)
        || (codePoint >= 0x0C70 && codePoint <= 0x0C81)
        || codePoint == 0x0C84
        || codePoint == 0x0C8D
        || codePoint == 0x0C91
        || codePoint == 0x0CA9
        || codePoint == 0x0CB4
        || (codePoint >= 0x0CBA && codePoint <= 0x0CBD)
        || codePoint == 0x0CC5
        || codePoint == 0x0CC9
        || (codePoint >= 0x0CCE && codePoint <= 0x0CD4)
        || (codePoint >= 0x0CD7 && codePoint <= 0x0CDD)
        || codePoint == 0x0CDF
        || (codePoint >= 0x0CE2 && codePoint <= 0x0CE5)
        || (codePoint >= 0x0CF0 && codePoint <= 0x0D01)
        || codePoint == 0x0D04
        || codePoint == 0x0D0D
        || codePoint == 0x0D11
        || codePoint == 0x0D29
        || (codePoint >= 0x0D3A && codePoint <= 0x0D3D)
        || (codePoint >= 0x0D44 && codePoint <= 0x0D45)
        || codePoint == 0x0D49
        || (codePoint >= 0x0D4E && codePoint <= 0x0D56)
        || (codePoint >= 0x0D58 && codePoint <= 0x0D5F)
        || (codePoint >= 0x0D62 && codePoint <= 0x0D65)
        || (codePoint >= 0x0D70 && codePoint <= 0x0D81)
        || codePoint == 0x0D84
        || (codePoint >= 0x0D97 && codePoint <= 0x0D99)
        || codePoint == 0x0DB2
        || codePoint == 0x0DBC
        || (codePoint >= 0x0DBE && codePoint <= 0x0DBF)
        || (codePoint >= 0x0DC7 && codePoint <= 0x0DC9)
        || (codePoint >= 0x0DCB && codePoint <= 0x0DCE)
        || codePoint == 0x0DD5
        || codePoint == 0x0DD7
        || (codePoint >= 0x0DE0 && codePoint <= 0x0DF1)
        || (codePoint >= 0x0DF5 && codePoint <= 0x0E00)
        || (codePoint >= 0x0E3B && codePoint <= 0x0E3E)
        || (codePoint >= 0x0E5C && codePoint <= 0x0E80)
        || codePoint == 0x0E83
        || (codePoint >= 0x0E85 && codePoint <= 0x0E86)
        || codePoint == 0x0E89
        || (codePoint >= 0x0E8B && codePoint <= 0x0E8C)
        || (codePoint >= 0x0E8E && codePoint <= 0x0E93)
        || codePoint == 0x0E98
        || codePoint == 0x0EA0
        || codePoint == 0x0EA4
        || codePoint == 0x0EA6
        || (codePoint >= 0x0EA8 && codePoint <= 0x0EA9)
        || codePoint == 0x0EAC
        || codePoint == 0x0EBA
        || (codePoint >= 0x0EBE && codePoint <= 0x0EBF)
        || codePoint == 0x0EC5
        || codePoint == 0x0EC7
        || (codePoint >= 0x0ECE && codePoint <= 0x0ECF)
        || (codePoint >= 0x0EDA && codePoint <= 0x0EDB)
        || (codePoint >= 0x0EDE && codePoint <= 0x0EFF)
        || codePoint == 0x0F48
        || (codePoint >= 0x0F6B && codePoint <= 0x0F70)
        || (codePoint >= 0x0F8C && codePoint <= 0x0F8F)
        || codePoint == 0x0F98
        || codePoint == 0x0FBD
        || (codePoint >= 0x0FCD && codePoint <= 0x0FCE)
        || (codePoint >= 0x0FD0 && codePoint <= 0x0FFF)
        || codePoint == 0x1022
        || codePoint == 0x1028
        || codePoint == 0x102B
        || (codePoint >= 0x1033 && codePoint <= 0x1035)
        || (codePoint >= 0x103A && codePoint <= 0x103F)
        || (codePoint >= 0x105A && codePoint <= 0x109F)
        || (codePoint >= 0x10C6 && codePoint <= 0x10CF)
        || (codePoint >= 0x10F9 && codePoint <= 0x10FA)
        || (codePoint >= 0x10FC && codePoint <= 0x10FF)
        || (codePoint >= 0x115A && codePoint <= 0x115E)
        || (codePoint >= 0x11A3 && codePoint <= 0x11A7)
        || (codePoint >= 0x11FA && codePoint <= 0x11FF)
        || codePoint == 0x1207
        || codePoint == 0x1247
        || codePoint == 0x1249
        || (codePoint >= 0x124E && codePoint <= 0x124F)
        || codePoint == 0x1257
        || codePoint == 0x1259
        || (codePoint >= 0x125E && codePoint <= 0x125F)
        || codePoint == 0x1287
        || codePoint == 0x1289
        || (codePoint >= 0x128E && codePoint <= 0x128F)
        || codePoint == 0x12AF
        || codePoint == 0x12B1
        || (codePoint >= 0x12B6 && codePoint <= 0x12B7)
        || codePoint == 0x12BF
        || codePoint == 0x12C1
        || (codePoint >= 0x12C6 && codePoint <= 0x12C7)
        || codePoint == 0x12CF
        || codePoint == 0x12D7
        || codePoint == 0x12EF
        || codePoint == 0x130F
        || codePoint == 0x1311
        || (codePoint >= 0x1316 && codePoint <= 0x1317)
        || codePoint == 0x131F
        || codePoint == 0x1347
        || (codePoint >= 0x135B && codePoint <= 0x1360)
        || (codePoint >= 0x137D && codePoint <= 0x139F)
        || (codePoint >= 0x13F5 && codePoint <= 0x1400)
        || (codePoint >= 0x1677 && codePoint <= 0x167F)
        || (codePoint >= 0x169D && codePoint <= 0x169F)
        || (codePoint >= 0x16F1 && codePoint <= 0x16FF)
        || codePoint == 0x170D
        || (codePoint >= 0x1715 && codePoint <= 0x171F)
        || (codePoint >= 0x1737 && codePoint <= 0x173F)
        || (codePoint >= 0x1754 && codePoint <= 0x175F)
        || codePoint == 0x176D
        || codePoint == 0x1771
        || (codePoint >= 0x1774 && codePoint <= 0x177F)
        || (codePoint >= 0x17DD && codePoint <= 0x17DF)
        || (codePoint >= 0x17EA && codePoint <= 0x17FF)
        || codePoint == 0x180F
        || (codePoint >= 0x181A && codePoint <= 0x181F)
        || (codePoint >= 0x1878 && codePoint <= 0x187F)
        || (codePoint >= 0x18AA && codePoint <= 0x1DFF)
        || (codePoint >= 0x1E9C && codePoint <= 0x1E9F)
        || (codePoint >= 0x1EFA && codePoint <= 0x1EFF)
        || (codePoint >= 0x1F16 && codePoint <= 0x1F17)
        || (codePoint >= 0x1F1E && codePoint <= 0x1F1F)
        || (codePoint >= 0x1F46 && codePoint <= 0x1F47)
        || (codePoint >= 0x1F4E && codePoint <= 0x1F4F)
        || codePoint == 0x1F58
        || codePoint == 0x1F5A
        || codePoint == 0x1F5C
        || codePoint == 0x1F5E
        || (codePoint >= 0x1F7E && codePoint <= 0x1F7F)
        || codePoint == 0x1FB5
        || codePoint == 0x1FC5
        || (codePoint >= 0x1FD4 && codePoint <= 0x1FD5)
        || codePoint == 0x1FDC
        || (codePoint >= 0x1FF0 && codePoint <= 0x1FF1)
        || codePoint == 0x1FF5
        || codePoint == 0x1FFF
        || (codePoint >= 0x2053 && codePoint <= 0x2056)
        || (codePoint >= 0x2058 && codePoint <= 0x205E)
        || (codePoint >= 0x2064 && codePoint <= 0x2069)
        || (codePoint >= 0x2072 && codePoint <= 0x2073)
        || (codePoint >= 0x208F && codePoint <= 0x209F)
        || (codePoint >= 0x20B2 && codePoint <= 0x20CF)
        || (codePoint >= 0x20EB && codePoint <= 0x20FF)
        || (codePoint >= 0x213B && codePoint <= 0x213C)
        || (codePoint >= 0x214C && codePoint <= 0x2152)
        || (codePoint >= 0x2184 && codePoint <= 0x218F)
        || (codePoint >= 0x23CF && codePoint <= 0x23FF)
        || (codePoint >= 0x2427 && codePoint <= 0x243F)
        || (codePoint >= 0x244B && codePoint <= 0x245F)
        || codePoint == 0x24FF
        || (codePoint >= 0x2614 && codePoint <= 0x2615)
        || codePoint == 0x2618
        || (codePoint >= 0x267E && codePoint <= 0x267F)
        || (codePoint >= 0x268A && codePoint <= 0x2700)
        || codePoint == 0x2705
        || (codePoint >= 0x270A && codePoint <= 0x270B)
        || codePoint == 0x2728
        || codePoint == 0x274C
        || codePoint == 0x274E
        || (codePoint >= 0x2753 && codePoint <= 0x2755)
        || codePoint == 0x2757
        || (codePoint >= 0x275F && codePoint <= 0x2760)
        || (codePoint >= 0x2795 && codePoint <= 0x2797)
        || codePoint == 0x27B0
        || (codePoint >= 0x27BF && codePoint <= 0x27CF)
        || (codePoint >= 0x27EC && codePoint <= 0x27EF)
        || (codePoint >= 0x2B00 && codePoint <= 0x2E7F)
        || codePoint == 0x2E9A
        || (codePoint >= 0x2EF4 && codePoint <= 0x2EFF)
        || (codePoint >= 0x2FD6 && codePoint <= 0x2FEF)
        || (codePoint >= 0x2FFC && codePoint <= 0x2FFF)
        || codePoint == 0x3040
        || (codePoint >= 0x3097 && codePoint <= 0x3098)
        || (codePoint >= 0x3100 && codePoint <= 0x3104)
        || (codePoint >= 0x312D && codePoint <= 0x3130)
        || codePoint == 0x318F
        || (codePoint >= 0x31B8 && codePoint <= 0x31EF)
        || (codePoint >= 0x321D && codePoint <= 0x321F)
        || (codePoint >= 0x3244 && codePoint <= 0x3250)
        || (codePoint >= 0x327C && codePoint <= 0x327E)
        || (codePoint >= 0x32CC && codePoint <= 0x32CF)
        || codePoint == 0x32FF
        || (codePoint >= 0x3377 && codePoint <= 0x337A)
        || (codePoint >= 0x33DE && codePoint <= 0x33DF)
        || codePoint == 0x33FF
        || (codePoint >= 0x4DB6 && codePoint <= 0x4DFF)
        || (codePoint >= 0x9FA6 && codePoint <= 0x9FFF)
        || (codePoint >= 0xA48D && codePoint <= 0xA48F)
        || (codePoint >= 0xA4C7 && codePoint <= 0xABFF)
        || (codePoint >= 0xD7A4 && codePoint <= 0xD7FF)
        || (codePoint >= 0xFA2E && codePoint <= 0xFA2F)
        || (codePoint >= 0xFA6B && codePoint <= 0xFAFF)
        || (codePoint >= 0xFB07 && codePoint <= 0xFB12)
        || (codePoint >= 0xFB18 && codePoint <= 0xFB1C)
        || codePoint == 0xFB37
        || codePoint == 0xFB3D
        || codePoint == 0xFB3F
        || codePoint == 0xFB42
        || codePoint == 0xFB45
        || (codePoint >= 0xFBB2 && codePoint <= 0xFBD2)
        || (codePoint >= 0xFD40 && codePoint <= 0xFD4F)
        || (codePoint >= 0xFD90 && codePoint <= 0xFD91)
        || (codePoint >= 0xFDC8 && codePoint <= 0xFDCF)
        || (codePoint >= 0xFDFD && codePoint <= 0xFDFF)
        || (codePoint >= 0xFE10 && codePoint <= 0xFE1F)
        || (codePoint >= 0xFE24 && codePoint <= 0xFE2F)
        || (codePoint >= 0xFE47 && codePoint <= 0xFE48)
        || codePoint == 0xFE53
        || codePoint == 0xFE67
        || (codePoint >= 0xFE6C && codePoint <= 0xFE6F)
        || codePoint == 0xFE75
        || (codePoint >= 0xFEFD && codePoint <= 0xFEFE)
        || codePoint == 0xFF00
        || (codePoint >= 0xFFBF && codePoint <= 0xFFC1)
        || (codePoint >= 0xFFC8 && codePoint <= 0xFFC9)
        || (codePoint >= 0xFFD0 && codePoint <= 0xFFD1)
        || (codePoint >= 0xFFD8 && codePoint <= 0xFFD9)
        || (codePoint >= 0xFFDD && codePoint <= 0xFFDF)
        || codePoint == 0xFFE7
        || (codePoint >= 0xFFEF && codePoint <= 0xFFF8)
        || (codePoint >= 0x10000 && codePoint <= 0x102FF)
        || codePoint == 0x1031F
        || (codePoint >= 0x10324 && codePoint <= 0x1032F)
        || (codePoint >= 0x1034B && codePoint <= 0x103FF)
        || (codePoint >= 0x10426 && codePoint <= 0x10427)
        || (codePoint >= 0x1044E && codePoint <= 0x1CFFF)
        || (codePoint >= 0x1D0F6 && codePoint <= 0x1D0FF)
        || (codePoint >= 0x1D127 && codePoint <= 0x1D129)
        || (codePoint >= 0x1D1DE && codePoint <= 0x1D3FF)
        || codePoint == 0x1D455
        || codePoint == 0x1D49D
        || (codePoint >= 0x1D4A0 && codePoint <= 0x1D4A1)
        || (codePoint >= 0x1D4A3 && codePoint <= 0x1D4A4)
        || (codePoint >= 0x1D4A7 && codePoint <= 0x1D4A8)
        || codePoint == 0x1D4AD
        || codePoint == 0x1D4BA
        || codePoint == 0x1D4BC
        || codePoint == 0x1D4C1
        || codePoint == 0x1D4C4
        || codePoint == 0x1D506
        || (codePoint >= 0x1D50B && codePoint <= 0x1D50C)
        || codePoint == 0x1D515
        || codePoint == 0x1D51D
        || codePoint == 0x1D53A
        || codePoint == 0x1D53F
        || codePoint == 0x1D545
        || (codePoint >= 0x1D547 && codePoint <= 0x1D549)
        || codePoint == 0x1D551
        || (codePoint >= 0x1D6A4 && codePoint <= 0x1D6A7)
        || (codePoint >= 0x1D7CA && codePoint <= 0x1D7CD)
        || (codePoint >= 0x1D800 && codePoint <= 0x1FFFD)
        || (codePoint >= 0x2A6D7 && codePoint <= 0x2F7FF)
        || (codePoint >= 0x2FA1E && codePoint <= 0x2FFFD)
        || (codePoint >= 0x30000 && codePoint <= 0x3FFFD)
        || (codePoint >= 0x40000 && codePoint <= 0x4FFFD)
        || (codePoint >= 0x50000 && codePoint <= 0x5FFFD)
        || (codePoint >= 0x60000 && codePoint <= 0x6FFFD)
        || (codePoint >= 0x70000 && codePoint <= 0x7FFFD)
        || (codePoint >= 0x80000 && codePoint <= 0x8FFFD)
        || (codePoint >= 0x90000 && codePoint <= 0x9FFFD)
        || (codePoint >= 0xA0000 && codePoint <= 0xAFFFD)
        || (codePoint >= 0xB0000 && codePoint <= 0xBFFFD)
        || (codePoint >= 0xC0000 && codePoint <= 0xCFFFD)
        || (codePoint >= 0xD0000 && codePoint <= 0xDFFFD)
        || codePoint == 0xE0000
        || (codePoint >= 0xE0002 && codePoint <= 0xE001F)
        || (codePoint >= 0xE0080 && codePoint <= 0xEFFFD)
        ;
  }

  /**
   * Commonly mapped to nothing.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "Commonly mapped to nothing".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-B.1">RFC 3454, Appendix B.1</a>
   */
  public static boolean mapToNothing(int codePoint) {
    return codePoint == 0x00AD
        || codePoint == 0x034F
        || codePoint == 0x1806
        || codePoint == 0x180B
        || codePoint == 0x180C
        || codePoint == 0x180D
        || codePoint == 0x200B
        || codePoint == 0x200C
        || codePoint == 0x200D
        || codePoint == 0x2060
        || codePoint == 0xFE00
        || codePoint == 0xFE01
        || codePoint == 0xFE02
        || codePoint == 0xFE03
        || codePoint == 0xFE04
        || codePoint == 0xFE05
        || codePoint == 0xFE06
        || codePoint == 0xFE07
        || codePoint == 0xFE08
        || codePoint == 0xFE09
        || codePoint == 0xFE0A
        || codePoint == 0xFE0B
        || codePoint == 0xFE0C
        || codePoint == 0xFE0D
        || codePoint == 0xFE0E
        || codePoint == 0xFE0F
        || codePoint == 0xFEFF
        ;
  }

  /**
   * Mapping for case-folding used with NFKC.
   *
   * @param codePoint the character (Unicode code point) to be mapped.
   * @return  Case-folding used with NFKC for the given {@code codePoint}.
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-B.2">RFC 3454, Appendix B.2</a>
   */
  public static int[] mapWithNfkc(int codePoint) {
    switch (codePoint) {
      case 0x00C5:
        return new int[] {0x00E5};
      case 0x00C6:
        return new int[] {0x00E6};
      case 0x00C3:
        return new int[] {0x00E3};
      case 0x00C4:
        return new int[] {0x00E4};
      case 0x00C9:
        return new int[] {0x00E9};
      case 0x00C7:
        return new int[] {0x00E7};
      case 0x00C8:
        return new int[] {0x00E8};
      case 0x1D6D3:
        return new int[] {0x03C3};
      case 0x00C1:
        return new int[] {0x00E1};
      case 0x00C2:
        return new int[] {0x00E2};
      case 0x00C0:
        return new int[] {0x00E0};
      case 0x00D6:
        return new int[] {0x00F6};
      case 0x00D4:
        return new int[] {0x00F4};
      case 0x00D5:
        return new int[] {0x00F5};
      case 0x00D8:
        return new int[] {0x00F8};
      case 0x00D9:
        return new int[] {0x00F9};
      case 0x1D4A2:
        return new int[] {0x0067};
      case 0x1D6E4:
        return new int[] {0x03B3};
      case 0x1D6E5:
        return new int[] {0x03B4};
      case 0x1D6E2:
        return new int[] {0x03B1};
      case 0x1D6E3:
        return new int[] {0x03B2};
      case 0x00D2:
        return new int[] {0x00F2};
      case 0x1D4A6:
        return new int[] {0x006B};
      case 0x1D6E8:
        return new int[] {0x03B7};
      case 0x00D3:
        return new int[] {0x00F3};
      case 0x1D6E9:
        return new int[] {0x03B8};
      case 0x00D0:
        return new int[] {0x00F0};
      case 0x1D6E6:
        return new int[] {0x03B5};
      case 0x00D1:
        return new int[] {0x00F1};
      case 0x1D4A5:
        return new int[] {0x006A};
      case 0x1D6E7:
        return new int[] {0x03B6};
      case 0x00CE:
        return new int[] {0x00EE};
      case 0x00CF:
        return new int[] {0x00EF};
      case 0x00CC:
        return new int[] {0x00EC};
      case 0x00CD:
        return new int[] {0x00ED};
      case 0x1D4A9:
        return new int[] {0x006E};
      case 0x1D6EA:
        return new int[] {0x03B9};
      case 0x1D4AB:
        return new int[] {0x0070};
      case 0x1D6ED:
        return new int[] {0x03BC};
      case 0x1D4AC:
        return new int[] {0x0071};
      case 0x1D6EE:
        return new int[] {0x03BD};
      case 0x1D6EB:
        return new int[] {0x03BA};
      case 0x1D4AA:
        return new int[] {0x006F};
      case 0x1D6EC:
        return new int[] {0x03BB};
      case 0x00CA:
        return new int[] {0x00EA};
      case 0x1D4AF:
        return new int[] {0x0074};
      case 0x00CB:
        return new int[] {0x00EB};
      case 0x1D6EF:
        return new int[] {0x03BE};
      case 0x1D4AE:
        return new int[] {0x0073};
      case 0x33B5:
        return new int[] {0x006E, 0x0076};
      case 0x33B4:
        return new int[] {0x0070, 0x0076};
      case 0x1D6AF:
        return new int[] {0x03B8};
      case 0x33B9:
        return new int[] {0x006D, 0x0076};
      case 0x33B8:
        return new int[] {0x006B, 0x0076};
      case 0x33B7:
        return new int[] {0x006D, 0x0076};
      case 0x33B6:
        return new int[] {0x03BC, 0x0076};
      case 0x1D6B1:
        return new int[] {0x03BA};
      case 0x1D6B2:
        return new int[] {0x03BB};
      case 0x1D6B0:
        return new int[] {0x03B9};
      case 0x1D6B5:
        return new int[] {0x03BE};
      case 0x1D6B6:
        return new int[] {0x03BF};
      case 0x1D6B3:
        return new int[] {0x03BC};
      case 0x1D6B4:
        return new int[] {0x03BD};
      case 0x00DF:
        return new int[] {0x0073, 0x0073};
      case 0x1D6B9:
        return new int[] {0x03B8};
      case 0x33AC:
        return new int[] {0x0067, 0x0070, 0x0061};
      case 0x00DD:
        return new int[] {0x00FD};
      case 0x33AB:
        return new int[] {0x006D, 0x0070, 0x0061};
      case 0x1D6B7:
        return new int[] {0x03C0};
      case 0x00DE:
        return new int[] {0x00FE};
      case 0x33AA:
        return new int[] {0x006B, 0x0070, 0x0061};
      case 0x1D6B8:
        return new int[] {0x03C1};
      case 0x1D6BA:
        return new int[] {0x03C3};
      case 0x1D6BB:
        return new int[] {0x03C4};
      case 0x33A9:
        return new int[] {0x0070, 0x0061};
      case 0x00DB:
        return new int[] {0x00FB};
      case 0x1D6BE:
        return new int[] {0x03C7};
      case 0x00DC:
        return new int[] {0x00FC};
      case 0x1D6BF:
        return new int[] {0x03C8};
      case 0x1D6BC:
        return new int[] {0x03C5};
      case 0x00DA:
        return new int[] {0x00FA};
      case 0x1D6BD:
        return new int[] {0x03C6};
      case 0x33C6:
        return new int[] {0x0063, 0x2215, 0x006B, 0x0067};
      case 0x33C3:
        return new int[] {0x0062, 0x0071};
      case 0x33C9:
        return new int[] {0x0067, 0x0079};
      case 0x33C8:
        return new int[] {0x0064, 0x0062};
      case 0x33C7:
        return new int[] {0x0063, 0x006F, 0x002E};
      case 0x1D6C0:
        return new int[] {0x03C9};
      case 0x33C1:
        return new int[] {0x006D, 0x03C9};
      case 0x33C0:
        return new int[] {0x006B, 0x03C9};
      case 0x33BE:
        return new int[] {0x006B, 0x0077};
      case 0x33BD:
        return new int[] {0x006D, 0x0077};
      case 0x33BC:
        return new int[] {0x03BC, 0x0077};
      case 0x33BB:
        return new int[] {0x006E, 0x0077};
      case 0x33BF:
        return new int[] {0x006D, 0x0077};
      case 0x33BA:
        return new int[] {0x0070, 0x0077};
      case 0x24B7:
        return new int[] {0x24D1};
      case 0x24B6:
        return new int[] {0x24D0};
      case 0x1D6A8:
        return new int[] {0x03B1};
      case 0x1D6A9:
        return new int[] {0x03B2};
      case 0x1D6AA:
        return new int[] {0x03B3};
      case 0x1D6AD:
        return new int[] {0x03B6};
      case 0x1D6AE:
        return new int[] {0x03B7};
      case 0x1D6AB:
        return new int[] {0x03B4};
      case 0x1D6AC:
        return new int[] {0x03B5};
      case 0x24C4:
        return new int[] {0x24DE};
      case 0x24C3:
        return new int[] {0x24DD};
      case 0x1D49C:
        return new int[] {0x0061};
      case 0x24C2:
        return new int[] {0x24DC};
      case 0x24C1:
        return new int[] {0x24DB};
      case 0x24C8:
        return new int[] {0x24E2};
      case 0x1D49F:
        return new int[] {0x0064};
      case 0x24C7:
        return new int[] {0x24E1};
      case 0x24C6:
        return new int[] {0x24E0};
      case 0x24C5:
        return new int[] {0x24DF};
      case 0x1D49E:
        return new int[] {0x0063};
      case 0x24C0:
        return new int[] {0x24DA};
      case 0x24BC:
        return new int[] {0x24D6};
      case 0x24BB:
        return new int[] {0x24D5};
      case 0x24BA:
        return new int[] {0x24D4};
      case 0x24BF:
        return new int[] {0x24D9};
      case 0x24BE:
        return new int[] {0x24D8};
      case 0x24BD:
        return new int[] {0x24D7};
      case 0x24B9:
        return new int[] {0x24D3};
      case 0x24B8:
        return new int[] {0x24D2};
      case 0x00B5:
        return new int[] {0x03BC};
      case 0x24CD:
        return new int[] {0x24E7};
      case 0x24CC:
        return new int[] {0x24E6};
      case 0x24CB:
        return new int[] {0x24E5};
      case 0x24CA:
        return new int[] {0x24E4};
      case 0x24CF:
        return new int[] {0x24E9};
      case 0x24CE:
        return new int[] {0x24E8};
      case 0x24C9:
        return new int[] {0x24E3};
      case 0x054A:
        return new int[] {0x057A};
      case 0x054B:
        return new int[] {0x057B};
      case 0x1E10:
        return new int[] {0x1E11};
      case 0x054E:
        return new int[] {0x057E};
      case 0x054F:
        return new int[] {0x057F};
      case 0x1E14:
        return new int[] {0x1E15};
      case 0x054C:
        return new int[] {0x057C};
      case 0x054D:
        return new int[] {0x057D};
      case 0x1E12:
        return new int[] {0x1E13};
      case 0x0549:
        return new int[] {0x0579};
      case 0x0547:
        return new int[] {0x0577};
      case 0x0548:
        return new int[] {0x0578};
      case 0x1E0E:
        return new int[] {0x1E0F};
      case 0x0541:
        return new int[] {0x0571};
      case 0x0542:
        return new int[] {0x0572};
      case 0x0540:
        return new int[] {0x0570};
      case 0x0545:
        return new int[] {0x0575};
      case 0x0546:
        return new int[] {0x0576};
      case 0x1E0C:
        return new int[] {0x1E0D};
      case 0x0543:
        return new int[] {0x0573};
      case 0x0544:
        return new int[] {0x0574};
      case 0x1E0A:
        return new int[] {0x1E0B};
      case 0x1E06:
        return new int[] {0x1E07};
      case 0x053F:
        return new int[] {0x056F};
      case 0x1E04:
        return new int[] {0x1E05};
      case 0x1E08:
        return new int[] {0x1E09};
      case 0x1E20:
        return new int[] {0x1E21};
      case 0x1E24:
        return new int[] {0x1E25};
      case 0x1E22:
        return new int[] {0x1E23};
      case 0x1E1E:
        return new int[] {0x1E1F};
      case 0x0552:
        return new int[] {0x0582};
      case 0x0553:
        return new int[] {0x0583};
      case 0x0550:
        return new int[] {0x0580};
      case 0x0551:
        return new int[] {0x0581};
      case 0x0556:
        return new int[] {0x0586};
      case 0x1E1C:
        return new int[] {0x1E1D};
      case 0x0554:
        return new int[] {0x0584};
      case 0x1E1A:
        return new int[] {0x1E1B};
      case 0x0555:
        return new int[] {0x0585};
      case 0x1E18:
        return new int[] {0x1E19};
      case 0x1E16:
        return new int[] {0x1E17};
      case 0x1E32:
        return new int[] {0x1E33};
      case 0x1E30:
        return new int[] {0x1E31};
      case 0x1E36:
        return new int[] {0x1E37};
      case 0x1E34:
        return new int[] {0x1E35};
      case 0x1E2A:
        return new int[] {0x1E2B};
      case 0x1E2E:
        return new int[] {0x1E2F};
      case 0x1E2C:
        return new int[] {0x1E2D};
      case 0x1E28:
        return new int[] {0x1E29};
      case 0x1E26:
        return new int[] {0x1E27};
      case 0x1E42:
        return new int[] {0x1E43};
      case 0x1E40:
        return new int[] {0x1E41};
      case 0x1E46:
        return new int[] {0x1E47};
      case 0x1E44:
        return new int[] {0x1E45};
      case 0x1E3A:
        return new int[] {0x1E3B};
      case 0x1E3E:
        return new int[] {0x1E3F};
      case 0x1E3C:
        return new int[] {0x1E3D};
      case 0x1E38:
        return new int[] {0x1E39};
      case 0x33D7:
        return new int[] {0x0070, 0x0068};
      case 0x050A:
        return new int[] {0x050B};
      case 0x1D4D1:
        return new int[] {0x0062};
      case 0x1D4D2:
        return new int[] {0x0063};
      case 0x20A8:
        return new int[] {0x0072, 0x0073};
      case 0x33D9:
        return new int[] {0x0070, 0x0070, 0x006D};
      case 0x1D4D0:
        return new int[] {0x0061};
      case 0x1D4D5:
        return new int[] {0x0066};
      case 0x0506:
        return new int[] {0x0507};
      case 0x1D4D6:
        return new int[] {0x0067};
      case 0x1D4D3:
        return new int[] {0x0064};
      case 0x0504:
        return new int[] {0x0505};
      case 0x1D4D4:
        return new int[] {0x0065};
      case 0x1D4D9:
        return new int[] {0x006A};
      case 0x1D4D7:
        return new int[] {0x0068};
      case 0x0508:
        return new int[] {0x0509};
      case 0x1D4D8:
        return new int[] {0x0069};
      case 0x33CE:
        return new int[] {0x006B, 0x006D};
      case 0x33CD:
        return new int[] {0x006B, 0x006B};
      case 0x1D4DA:
        return new int[] {0x006B};
      case 0x0502:
        return new int[] {0x0503};
      case 0x1D4DB:
        return new int[] {0x006C};
      case 0x0500:
        return new int[] {0x0501};
      case 0x1D4DE:
        return new int[] {0x006F};
      case 0x1D4DF:
        return new int[] {0x0070};
      case 0x1D4DC:
        return new int[] {0x006D};
      case 0x1D4DD:
        return new int[] {0x006E};
      case 0x33CB:
        return new int[] {0x0068, 0x0070};
      case 0x1D4E2:
        return new int[] {0x0073};
      case 0x1D4E3:
        return new int[] {0x0074};
      case 0x1D4E0:
        return new int[] {0x0071};
      case 0x1D4E1:
        return new int[] {0x0072};
      case 0x1D4E6:
        return new int[] {0x0077};
      case 0x1D4E7:
        return new int[] {0x0078};
      case 0x1D4E4:
        return new int[] {0x0075};
      case 0x1D4E5:
        return new int[] {0x0076};
      case 0x1D4E8:
        return new int[] {0x0079};
      case 0x1D4E9:
        return new int[] {0x007A};
      case 0x33DD:
        return new int[] {0x0077, 0x0062};
      case 0x050E:
        return new int[] {0x050F};
      case 0x050C:
        return new int[] {0x050D};
      case 0x33DC:
        return new int[] {0x0073, 0x0076};
      case 0x33DA:
        return new int[] {0x0070, 0x0072};
      case 0xFF30:
        return new int[] {0xFF50};
      case 0xFF31:
        return new int[] {0xFF51};
      case 0xFF32:
        return new int[] {0xFF52};
      case 0x1D6F1:
        return new int[] {0x03C0};
      case 0x1D4B0:
        return new int[] {0x0075};
      case 0x1D6F2:
        return new int[] {0x03C1};
      case 0x1D6F0:
        return new int[] {0x03BF};
      case 0xFF37:
        return new int[] {0xFF57};
      case 0x1D4B3:
        return new int[] {0x0078};
      case 0x1D6F5:
        return new int[] {0x03C4};
      case 0xFF38:
        return new int[] {0xFF58};
      case 0x1D4B4:
        return new int[] {0x0079};
      case 0x1D6F6:
        return new int[] {0x03C5};
      case 0xFF39:
        return new int[] {0xFF59};
      case 0x1D4B1:
        return new int[] {0x0076};
      case 0x1D6F3:
        return new int[] {0x03B8};
      case 0x1D4B2:
        return new int[] {0x0077};
      case 0x1D6F4:
        return new int[] {0x03C3};
      case 0xFF33:
        return new int[] {0xFF53};
      case 0x1D6F9:
        return new int[] {0x03C8};
      case 0xFF34:
        return new int[] {0xFF54};
      case 0xFF35:
        return new int[] {0xFF55};
      case 0x1D4B5:
        return new int[] {0x007A};
      case 0x1D6F7:
        return new int[] {0x03C6};
      case 0xFF36:
        return new int[] {0xFF56};
      case 0x1D6F8:
        return new int[] {0x03C7};
      case 0xFF3A:
        return new int[] {0xFF5A};
      case 0x1D6FA:
        return new int[] {0x03C9};
      case 0x053A:
        return new int[] {0x056A};
      case 0xFF21:
        return new int[] {0xFF41};
      case 0x053D:
        return new int[] {0x056D};
      case 0x1E02:
        return new int[] {0x1E03};
      case 0x053E:
        return new int[] {0x056E};
      case 0x053B:
        return new int[] {0x056B};
      case 0x1E00:
        return new int[] {0x1E01};
      case 0x053C:
        return new int[] {0x056C};
      case 0x0538:
        return new int[] {0x0568};
      case 0xFF26:
        return new int[] {0xFF46};
      case 0x0539:
        return new int[] {0x0569};
      case 0xFF27:
        return new int[] {0xFF47};
      case 0x0536:
        return new int[] {0x0566};
      case 0xFF28:
        return new int[] {0xFF48};
      case 0x0537:
        return new int[] {0x0567};
      case 0xFF29:
        return new int[] {0xFF49};
      case 0xFF22:
        return new int[] {0xFF42};
      case 0xFF23:
        return new int[] {0xFF43};
      case 0xFF24:
        return new int[] {0xFF44};
      case 0xFF25:
        return new int[] {0xFF45};
      case 0x0531:
        return new int[] {0x0561};
      case 0xFF2A:
        return new int[] {0xFF4A};
      case 0x0534:
        return new int[] {0x0564};
      case 0x0535:
        return new int[] {0x0565};
      case 0x0532:
        return new int[] {0x0562};
      case 0x0533:
        return new int[] {0x0563};
      case 0xFF2F:
        return new int[] {0xFF4F};
      case 0xFF2B:
        return new int[] {0xFF4B};
      case 0xFF2C:
        return new int[] {0xFF4C};
      case 0xFF2D:
        return new int[] {0xFF4D};
      case 0xFF2E:
        return new int[] {0xFF4E};
      case 0x014E:
        return new int[] {0x014F};
      case 0x1E97:
        return new int[] {0x0074, 0x0308};
      case 0x1E98:
        return new int[] {0x0077, 0x030A};
      case 0x014C:
        return new int[] {0x014D};
      case 0x038E:
        return new int[] {0x03CD};
      case 0x038F:
        return new int[] {0x03CE};
      case 0x1E96:
        return new int[] {0x0068, 0x0331};
      case 0x1E99:
        return new int[] {0x0079, 0x030A};
      case 0x1E90:
        return new int[] {0x1E91};
      case 0x1D63C:
        return new int[] {0x0061};
      case 0x014A:
        return new int[] {0x014B};
      case 0x038C:
        return new int[] {0x03CC};
      case 0x1D63F:
        return new int[] {0x0064};
      case 0x1E94:
        return new int[] {0x1E95};
      case 0x038A:
        return new int[] {0x03AF};
      case 0x1D63D:
        return new int[] {0x0062};
      case 0x1E92:
        return new int[] {0x1E93};
      case 0x1D63E:
        return new int[] {0x0063};
      case 0x0145:
        return new int[] {0x0146};
      case 0x0388:
        return new int[] {0x03AD};
      case 0x0143:
        return new int[] {0x0144};
      case 0x0386:
        return new int[] {0x03AC};
      case 0x1E8E:
        return new int[] {0x1E8F};
      case 0x0149:
        return new int[] {0x02BC, 0x006E};
      case 0x1D640:
        return new int[] {0x0065};
      case 0x0147:
        return new int[] {0x0148};
      case 0x0389:
        return new int[] {0x03AE};
      case 0x1D401:
        return new int[] {0x0062};
      case 0x1D643:
        return new int[] {0x0068};
      case 0x1D402:
        return new int[] {0x0063};
      case 0x1D644:
        return new int[] {0x0069};
      case 0x1D641:
        return new int[] {0x0066};
      case 0x1D400:
        return new int[] {0x0061};
      case 0x1D642:
        return new int[] {0x0067};
      case 0x0141:
        return new int[] {0x0142};
      case 0x1D405:
        return new int[] {0x0066};
      case 0x1D647:
        return new int[] {0x006C};
      case 0x1E8C:
        return new int[] {0x1E8D};
      case 0x1D406:
        return new int[] {0x0067};
      case 0x1D648:
        return new int[] {0x006D};
      case 0x1D403:
        return new int[] {0x0064};
      case 0x1D645:
        return new int[] {0x006A};
      case 0x1E8A:
        return new int[] {0x1E8B};
      case 0x1D404:
        return new int[] {0x0065};
      case 0x1D646:
        return new int[] {0x006B};
      case 0x1D409:
        return new int[] {0x006A};
      case 0x039F:
        return new int[] {0x03BF};
      case 0x1D407:
        return new int[] {0x0068};
      case 0x1D649:
        return new int[] {0x006E};
      case 0x015E:
        return new int[] {0x015F};
      case 0x1D408:
        return new int[] {0x0069};
      case 0x1D40A:
        return new int[] {0x006B};
      case 0x1D64C:
        return new int[] {0x0071};
      case 0x039A:
        return new int[] {0x03BA};
      case 0x1D40B:
        return new int[] {0x006C};
      case 0x1D64D:
        return new int[] {0x0072};
      case 0x1D64A:
        return new int[] {0x006F};
      case 0x1D64B:
        return new int[] {0x0070};
      case 0x039D:
        return new int[] {0x03BD};
      case 0x1D40E:
        return new int[] {0x006F};
      case 0x015C:
        return new int[] {0x015D};
      case 0x039E:
        return new int[] {0x03BE};
      case 0x1D40F:
        return new int[] {0x0070};
      case 0x039B:
        return new int[] {0x03BB};
      case 0x1D40C:
        return new int[] {0x006D};
      case 0x1D64E:
        return new int[] {0x0073};
      case 0x015A:
        return new int[] {0x015B};
      case 0x039C:
        return new int[] {0x03BC};
      case 0x1D40D:
        return new int[] {0x006E};
      case 0x1D64F:
        return new int[] {0x0074};
      case 0x0156:
        return new int[] {0x0157};
      case 0x0398:
        return new int[] {0x03B8};
      case 0x0399:
        return new int[] {0x03B9};
      case 0x0154:
        return new int[] {0x0155};
      case 0x0396:
        return new int[] {0x03B6};
      case 0x0397:
        return new int[] {0x03B7};
      case 0x1D650:
        return new int[] {0x0075};
      case 0x1D651:
        return new int[] {0x0076};
      case 0x0158:
        return new int[] {0x0159};
      case 0x0390:
        return new int[] {0x03B9, 0x0308, 0x0301};
      case 0x1D412:
        return new int[] {0x0073};
      case 0x1D654:
        return new int[] {0x0079};
      case 0x0391:
        return new int[] {0x03B1};
      case 0x1D413:
        return new int[] {0x0074};
      case 0x1D655:
        return new int[] {0x007A};
      case 0x1D410:
        return new int[] {0x0071};
      case 0x1D652:
        return new int[] {0x0077};
      case 0x1D411:
        return new int[] {0x0072};
      case 0x1D653:
        return new int[] {0x0078};
      case 0x0152:
        return new int[] {0x0153};
      case 0x0394:
        return new int[] {0x03B4};
      case 0x1D416:
        return new int[] {0x0077};
      case 0x0395:
        return new int[] {0x03B5};
      case 0x1D417:
        return new int[] {0x0078};
      case 0x0150:
        return new int[] {0x0151};
      case 0x0392:
        return new int[] {0x03B2};
      case 0x1E9A:
        return new int[] {0x0061, 0x02BE};
      case 0x1D414:
        return new int[] {0x0075};
      case 0x0393:
        return new int[] {0x03B3};
      case 0x1E9B:
        return new int[] {0x1E61};
      case 0x1D415:
        return new int[] {0x0076};
      case 0x210D:
        return new int[] {0x0068};
      case 0x1D618:
        return new int[] {0x0071};
      case 0x210C:
        return new int[] {0x0068};
      case 0x1D619:
        return new int[] {0x0072};
      case 0x016E:
        return new int[] {0x016F};
      case 0x210B:
        return new int[] {0x0068};
      case 0x1D616:
        return new int[] {0x006F};
      case 0x1D617:
        return new int[] {0x0070};
      case 0x1D61A:
        return new int[] {0x0073};
      case 0x2109:
        return new int[] {0x00B0, 0x0066};
      case 0x016C:
        return new int[] {0x016D};
      case 0x1D61D:
        return new int[] {0x0076};
      case 0x1D61E:
        return new int[] {0x0077};
      case 0x016A:
        return new int[] {0x016B};
      case 0x1D61B:
        return new int[] {0x0074};
      case 0x1D61C:
        return new int[] {0x0075};
      case 0x0168:
        return new int[] {0x0169};
      case 0x2103:
        return new int[] {0x00B0, 0x0063};
      case 0x2102:
        return new int[] {0x0063};
      case 0x1D61F:
        return new int[] {0x0078};
      case 0x0166:
        return new int[] {0x0167};
      case 0x2107:
        return new int[] {0x025B};
      case 0x1D621:
        return new int[] {0x007A};
      case 0x0160:
        return new int[] {0x0161};
      case 0x1D620:
        return new int[] {0x0079};
      case 0x0164:
        return new int[] {0x0165};
      case 0x0162:
        return new int[] {0x0163};
      case 0x211D:
        return new int[] {0x0072};
      case 0x017F:
        return new int[] {0x0073};
      case 0x211C:
        return new int[] {0x0072};
      case 0x211B:
        return new int[] {0x0072};
      case 0x017D:
        return new int[] {0x017E};
      case 0x211A:
        return new int[] {0x0071};
      case 0x017B:
        return new int[] {0x017C};
      case 0x0178:
        return new int[] {0x00FF};
      case 0x2115:
        return new int[] {0x006E};
      case 0x0179:
        return new int[] {0x017A};
      case 0x0176:
        return new int[] {0x0177};
      case 0x2112:
        return new int[] {0x006C};
      case 0x2119:
        return new int[] {0x0070};
      case 0x2116:
        return new int[] {0x006E, 0x006F};
      case 0x0170:
        return new int[] {0x0171};
      case 0x0174:
        return new int[] {0x0175};
      case 0x2111:
        return new int[] {0x0069};
      case 0x2110:
        return new int[] {0x0069};
      case 0x0172:
        return new int[] {0x0173};
      case 0x010A:
        return new int[] {0x010B};
      case 0x1E54:
        return new int[] {0x1E55};
      case 0xFB13:
        return new int[] {0x0574, 0x0576};
      case 0x1E52:
        return new int[] {0x1E53};
      case 0xFB14:
        return new int[] {0x0574, 0x0565};
      case 0x010E:
        return new int[] {0x010F};
      case 0x1E58:
        return new int[] {0x1E59};
      case 0x010C:
        return new int[] {0x010D};
      case 0x1E56:
        return new int[] {0x1E57};
      case 0x0108:
        return new int[] {0x0109};
      case 0xFB15:
        return new int[] {0x0574, 0x056B};
      case 0x1E50:
        return new int[] {0x1E51};
      case 0xFB16:
        return new int[] {0x057E, 0x0576};
      case 0xFB17:
        return new int[] {0x0574, 0x056D};
      case 0x0102:
        return new int[] {0x0103};
      case 0x1E4C:
        return new int[] {0x1E4D};
      case 0x0100:
        return new int[] {0x0101};
      case 0x1E4A:
        return new int[] {0x1E4B};
      case 0x0106:
        return new int[] {0x0107};
      case 0x0345:
        return new int[] {0x03B9};
      case 0x0587:
        return new int[] {0x0565, 0x0582};
      case 0x0104:
        return new int[] {0x0105};
      case 0x1E4E:
        return new int[] {0x1E4F};
      case 0x1E48:
        return new int[] {0x1E49};
      case 0x1E64:
        return new int[] {0x1E65};
      case 0xFB00:
        return new int[] {0x0066, 0x0066};
      case 0x011C:
        return new int[] {0x011D};
      case 0xFB01:
        return new int[] {0x0066, 0x0069};
      case 0x1D608:
        return new int[] {0x0061};
      case 0x1E62:
        return new int[] {0x1E63};
      case 0xFB02:
        return new int[] {0x0066, 0x006C};
      case 0x011A:
        return new int[] {0x011B};
      case 0xFB03:
        return new int[] {0x0066, 0x0066, 0x0069};
      case 0x1E68:
        return new int[] {0x1E69};
      case 0x1E66:
        return new int[] {0x1E67};
      case 0x1D609:
        return new int[] {0x0062};
      case 0x011E:
        return new int[] {0x011F};
      case 0x0118:
        return new int[] {0x0119};
      case 0x1E60:
        return new int[] {0x1E61};
      case 0xFB04:
        return new int[] {0x0066, 0x0066, 0x006C};
      case 0x1D60C:
        return new int[] {0x0065};
      case 0xFB05:
        return new int[] {0x0073, 0x0074};
      case 0x1D60D:
        return new int[] {0x0066};
      case 0xFB06:
        return new int[] {0x0073, 0x0074};
      case 0x1D60A:
        return new int[] {0x0063};
      case 0x1D60B:
        return new int[] {0x0064};
      case 0x0112:
        return new int[] {0x0113};
      case 0x1E5C:
        return new int[] {0x1E5D};
      case 0x0110:
        return new int[] {0x0111};
      case 0x1E5A:
        return new int[] {0x1E5B};
      case 0x1D60E:
        return new int[] {0x0067};
      case 0x1D60F:
        return new int[] {0x0068};
      case 0x0116:
        return new int[] {0x0117};
      case 0x0114:
        return new int[] {0x0115};
      case 0x1E5E:
        return new int[] {0x1E5F};
      case 0x1D610:
        return new int[] {0x0069};
      case 0x1D611:
        return new int[] {0x006A};
      case 0x1D614:
        return new int[] {0x006D};
      case 0x1D615:
        return new int[] {0x006E};
      case 0x1D612:
        return new int[] {0x006B};
      case 0x1D613:
        return new int[] {0x006C};
      case 0x012C:
        return new int[] {0x012D};
      case 0x1E76:
        return new int[] {0x1E77};
      case 0x012A:
        return new int[] {0x012B};
      case 0x1E74:
        return new int[] {0x1E75};
      case 0x012E:
        return new int[] {0x012F};
      case 0x1E78:
        return new int[] {0x1E79};
      case 0x1E72:
        return new int[] {0x1E73};
      case 0x1E70:
        return new int[] {0x1E71};
      case 0x0124:
        return new int[] {0x0125};
      case 0x1E6E:
        return new int[] {0x1E6F};
      case 0x0122:
        return new int[] {0x0123};
      case 0x1E6C:
        return new int[] {0x1E6D};
      case 0x0128:
        return new int[] {0x0129};
      case 0x0126:
        return new int[] {0x0127};
      case 0x0120:
        return new int[] {0x0121};
      case 0x1E6A:
        return new int[] {0x1E6B};
      case 0x013D:
        return new int[] {0x013E};
      case 0x1E86:
        return new int[] {0x1E87};
      case 0x013B:
        return new int[] {0x013C};
      case 0x1E84:
        return new int[] {0x1E85};
      case 0x013F:
        return new int[] {0x0140};
      case 0x1E88:
        return new int[] {0x1E89};
      case 0x1E82:
        return new int[] {0x1E83};
      case 0x1E80:
        return new int[] {0x1E81};
      case 0x037A:
        return new int[] {0x0020, 0x03B9};
      case 0x0134:
        return new int[] {0x0135};
      case 0x1E7E:
        return new int[] {0x1E7F};
      case 0x0132:
        return new int[] {0x0133};
      case 0x1E7C:
        return new int[] {0x1E7D};
      case 0x0139:
        return new int[] {0x013A};
      case 0x0136:
        return new int[] {0x0137};
      case 0x0130:
        return new int[] {0x0069, 0x0307};
      case 0x1E7A:
        return new int[] {0x1E7B};
      case 0x03A0:
        return new int[] {0x03C0};
      case 0x03A1:
        return new int[] {0x03C1};
      case 0x1D47A:
        return new int[] {0x0073};
      case 0x03A4:
        return new int[] {0x03C4};
      case 0x1EAC:
        return new int[] {0x1EAD};
      case 0x1D47D:
        return new int[] {0x0076};
      case 0x03A5:
        return new int[] {0x03C5};
      case 0x1D47E:
        return new int[] {0x0077};
      case 0x1EAA:
        return new int[] {0x1EAB};
      case 0x1D47B:
        return new int[] {0x0074};
      case 0x03A3:
        return new int[] {0x03C3};
      case 0x1D47C:
        return new int[] {0x0075};
      case 0x216B:
        return new int[] {0x217B};
      case 0x1EA8:
        return new int[] {0x1EA9};
      case 0x216A:
        return new int[] {0x217A};
      case 0x10425:
        return new int[] {0x1044D};
      case 0x1D47F:
        return new int[] {0x0078};
      case 0x1EA6:
        return new int[] {0x1EA7};
      case 0x216F:
        return new int[] {0x217F};
      case 0x216E:
        return new int[] {0x217E};
      case 0x216D:
        return new int[] {0x217D};
      case 0x216C:
        return new int[] {0x217C};
      case 0x1D481:
        return new int[] {0x007A};
      case 0x1EA0:
        return new int[] {0x1EA1};
      case 0x2169:
        return new int[] {0x2179};
      case 0x2168:
        return new int[] {0x2178};
      case 0x10420:
        return new int[] {0x10448};
      case 0x2167:
        return new int[] {0x2177};
      case 0x1D480:
        return new int[] {0x0079};
      case 0x10422:
        return new int[] {0x1044A};
      case 0x1EA4:
        return new int[] {0x1EA5};
      case 0x10421:
        return new int[] {0x10449};
      case 0x10424:
        return new int[] {0x1044C};
      case 0x1EA2:
        return new int[] {0x1EA3};
      case 0x10423:
        return new int[] {0x1044B};
      case 0x2162:
        return new int[] {0x2172};
      case 0x1041E:
        return new int[] {0x10446};
      case 0x2161:
        return new int[] {0x2171};
      case 0x1041D:
        return new int[] {0x10445};
      case 0x2160:
        return new int[] {0x2170};
      case 0x1041F:
        return new int[] {0x10447};
      case 0x2166:
        return new int[] {0x2176};
      case 0x2165:
        return new int[] {0x2175};
      case 0x2164:
        return new int[] {0x2174};
      case 0x2163:
        return new int[] {0x2173};
      case 0x1EBA:
        return new int[] {0x1EBB};
      case 0x03B0:
        return new int[] {0x03C5, 0x0308, 0x0301};
      case 0x1041A:
        return new int[] {0x10442};
      case 0x1EBE:
        return new int[] {0x1EBF};
      case 0x1041C:
        return new int[] {0x10444};
      case 0x1EBC:
        return new int[] {0x1EBD};
      case 0x1041B:
        return new int[] {0x10443};
      case 0x1EB8:
        return new int[] {0x1EB9};
      case 0x10415:
        return new int[] {0x1043D};
      case 0x10414:
        return new int[] {0x1043C};
      case 0x1EB6:
        return new int[] {0x1EB7};
      case 0x10417:
        return new int[] {0x1043F};
      case 0x10416:
        return new int[] {0x1043E};
      case 0x10419:
        return new int[] {0x10441};
      case 0x10418:
        return new int[] {0x10440};
      case 0x1EB0:
        return new int[] {0x1EB1};
      case 0x03AA:
        return new int[] {0x03CA};
      case 0x1EB4:
        return new int[] {0x1EB5};
      case 0x10411:
        return new int[] {0x10439};
      case 0x10410:
        return new int[] {0x10438};
      case 0x03AB:
        return new int[] {0x03CB};
      case 0x1EB2:
        return new int[] {0x1EB3};
      case 0x10413:
        return new int[] {0x1043B};
      case 0x10412:
        return new int[] {0x1043A};
      case 0x03A8:
        return new int[] {0x03C8};
      case 0x1040D:
        return new int[] {0x10435};
      case 0x03A9:
        return new int[] {0x03C9};
      case 0x1040C:
        return new int[] {0x10434};
      case 0x03A6:
        return new int[] {0x03C6};
      case 0x1EAE:
        return new int[] {0x1EAF};
      case 0x1040F:
        return new int[] {0x10437};
      case 0x03A7:
        return new int[] {0x03C7};
      case 0x1040E:
        return new int[] {0x10436};
      case 0x03C2:
        return new int[] {0x03C3};
      case 0x1ECA:
        return new int[] {0x1ECB};
      case 0x1ECE:
        return new int[] {0x1ECF};
      case 0x1ECC:
        return new int[] {0x1ECD};
      case 0x1EC8:
        return new int[] {0x1EC9};
      case 0x1EC2:
        return new int[] {0x1EC3};
      case 0x1EC0:
        return new int[] {0x1EC1};
      case 0x1EC6:
        return new int[] {0x1EC7};
      case 0x1EC4:
        return new int[] {0x1EC5};
      case 0x1D468:
        return new int[] {0x0061};
      case 0x1D469:
        return new int[] {0x0062};
      case 0x03D3:
        return new int[] {0x03CD};
      case 0x03D4:
        return new int[] {0x03CB};
      case 0x1EDC:
        return new int[] {0x1EDD};
      case 0x03D1:
        return new int[] {0x03B8};
      case 0x03D2:
        return new int[] {0x03C5};
      case 0x1EDA:
        return new int[] {0x1EDB};
      case 0x1D46C:
        return new int[] {0x0065};
      case 0x03D8:
        return new int[] {0x03D9};
      case 0x1D46D:
        return new int[] {0x0066};
      case 0x03D5:
        return new int[] {0x03C6};
      case 0x1D46A:
        return new int[] {0x0063};
      case 0x03D6:
        return new int[] {0x03C0};
      case 0x1EDE:
        return new int[] {0x1EDF};
      case 0x1D46B:
        return new int[] {0x0064};
      case 0x1ED8:
        return new int[] {0x1ED9};
      case 0x1D46E:
        return new int[] {0x0067};
      case 0x1D46F:
        return new int[] {0x0068};
      case 0x03D0:
        return new int[] {0x03B2};
      case 0x1ED2:
        return new int[] {0x1ED3};
      case 0x1D470:
        return new int[] {0x0069};
      case 0x1D471:
        return new int[] {0x006A};
      case 0x1ED0:
        return new int[] {0x1ED1};
      case 0x1ED6:
        return new int[] {0x1ED7};
      case 0x1D474:
        return new int[] {0x006D};
      case 0x1D475:
        return new int[] {0x006E};
      case 0x1ED4:
        return new int[] {0x1ED5};
      case 0x1D472:
        return new int[] {0x006B};
      case 0x1D473:
        return new int[] {0x006C};
      case 0x1D478:
        return new int[] {0x0071};
      case 0x1D479:
        return new int[] {0x0072};
      case 0x1D476:
        return new int[] {0x006F};
      case 0x1D477:
        return new int[] {0x0070};
      case 0x212D:
        return new int[] {0x0063};
      case 0x212C:
        return new int[] {0x0062};
      case 0x1D67B:
        return new int[] {0x006C};
      case 0x1D43A:
        return new int[] {0x0067};
      case 0x1D67C:
        return new int[] {0x006D};
      case 0x1D67A:
        return new int[] {0x006B};
      case 0x018A:
        return new int[] {0x0257};
      case 0x1D43D:
        return new int[] {0x006A};
      case 0x1D67F:
        return new int[] {0x0070};
      case 0x018B:
        return new int[] {0x018C};
      case 0x1D43E:
        return new int[] {0x006B};
      case 0x1D43B:
        return new int[] {0x0068};
      case 0x1D67D:
        return new int[] {0x006E};
      case 0x1D43C:
        return new int[] {0x0069};
      case 0x1D67E:
        return new int[] {0x006F};
      case 0x018E:
        return new int[] {0x01DD};
      case 0x212B:
        return new int[] {0x00E5};
      case 0x018F:
        return new int[] {0x0259};
      case 0x212A:
        return new int[] {0x006B};
      case 0x1D43F:
        return new int[] {0x006C};
      case 0x0189:
        return new int[] {0x0256};
      case 0x2126:
        return new int[] {0x03C9};
      case 0x1D680:
        return new int[] {0x0071};
      case 0x0187:
        return new int[] {0x0188};
      case 0x2124:
        return new int[] {0x007A};
      case 0x1D441:
        return new int[] {0x006E};
      case 0x1D683:
        return new int[] {0x0074};
      case 0x1D442:
        return new int[] {0x006F};
      case 0x1D684:
        return new int[] {0x0075};
      case 0x2128:
        return new int[] {0x007A};
      case 0x1D681:
        return new int[] {0x0072};
      case 0x1D440:
        return new int[] {0x006D};
      case 0x1D682:
        return new int[] {0x0073};
      case 0x0181:
        return new int[] {0x0253};
      case 0x1D445:
        return new int[] {0x0072};
      case 0x1D687:
        return new int[] {0x0078};
      case 0x0182:
        return new int[] {0x0183};
      case 0x1D446:
        return new int[] {0x0073};
      case 0x1D688:
        return new int[] {0x0079};
      case 0x1D443:
        return new int[] {0x0070};
      case 0x1D685:
        return new int[] {0x0076};
      case 0x1D444:
        return new int[] {0x0071};
      case 0x1D686:
        return new int[] {0x0077};
      case 0x2122:
        return new int[] {0x0074, 0x006D};
      case 0x1D449:
        return new int[] {0x0076};
      case 0x0186:
        return new int[] {0x0254};
      case 0x2121:
        return new int[] {0x0074, 0x0065, 0x006C};
      case 0x2120:
        return new int[] {0x0073, 0x006D};
      case 0x1D447:
        return new int[] {0x0074};
      case 0x1D689:
        return new int[] {0x007A};
      case 0x0184:
        return new int[] {0x0185};
      case 0x1D448:
        return new int[] {0x0075};
      case 0x213F:
        return new int[] {0x03C0};
      case 0x213E:
        return new int[] {0x03B3};
      case 0x1D44A:
        return new int[] {0x0077};
      case 0x1D44B:
        return new int[] {0x0078};
      case 0x019C:
        return new int[] {0x026F};
      case 0x1D44C:
        return new int[] {0x0079};
      case 0x1D44D:
        return new int[] {0x007A};
      case 0x019F:
        return new int[] {0x0275};
      case 0x019D:
        return new int[] {0x0272};
      case 0x0198:
        return new int[] {0x0199};
      case 0x0193:
        return new int[] {0x0260};
      case 0x0190:
        return new int[] {0x025B};
      case 0x0191:
        return new int[] {0x0192};
      case 0x0196:
        return new int[] {0x0269};
      case 0x2133:
        return new int[] {0x006D};
      case 0x0197:
        return new int[] {0x0268};
      case 0x0194:
        return new int[] {0x0263};
      case 0x2131:
        return new int[] {0x0066};
      case 0x2130:
        return new int[] {0x0065};
      case 0x1D418:
        return new int[] {0x0079};
      case 0x1D419:
        return new int[] {0x007A};
      case 0x1040B:
        return new int[] {0x10433};
      case 0x1040A:
        return new int[] {0x10432};
      case 0x10404:
        return new int[] {0x1042C};
      case 0x10403:
        return new int[] {0x1042B};
      case 0x10406:
        return new int[] {0x1042E};
      case 0x10405:
        return new int[] {0x1042D};
      case 0x10408:
        return new int[] {0x10430};
      case 0x10407:
        return new int[] {0x1042F};
      case 0x10409:
        return new int[] {0x10431};
      case 0x2145:
        return new int[] {0x0064};
      case 0x10400:
        return new int[] {0x10428};
      case 0x10402:
        return new int[] {0x1042A};
      case 0x10401:
        return new int[] {0x10429};
      case 0x1D672:
        return new int[] {0x0063};
      case 0x1D673:
        return new int[] {0x0064};
      case 0x1D670:
        return new int[] {0x0061};
      case 0x1D671:
        return new int[] {0x0062};
      case 0x1D434:
        return new int[] {0x0061};
      case 0x1D676:
        return new int[] {0x0067};
      case 0x1D435:
        return new int[] {0x0062};
      case 0x1D677:
        return new int[] {0x0068};
      case 0x1D674:
        return new int[] {0x0065};
      case 0x1D675:
        return new int[] {0x0066};
      case 0x1D438:
        return new int[] {0x0065};
      case 0x1D439:
        return new int[] {0x0066};
      case 0x1D436:
        return new int[] {0x0063};
      case 0x1D678:
        return new int[] {0x0069};
      case 0x1D437:
        return new int[] {0x0064};
      case 0x1D679:
        return new int[] {0x006A};
      case 0x01E6:
        return new int[] {0x01E7};
      case 0x01E4:
        return new int[] {0x01E5};
      case 0x01E8:
        return new int[] {0x01E9};
      case 0x1D5B2:
        return new int[] {0x0073};
      case 0x1D5B3:
        return new int[] {0x0074};
      case 0x1D5B0:
        return new int[] {0x0071};
      case 0x1D5B1:
        return new int[] {0x0072};
      case 0x01E2:
        return new int[] {0x01E3};
      case 0x1D5B6:
        return new int[] {0x0077};
      case 0x1D5B7:
        return new int[] {0x0078};
      case 0x01E0:
        return new int[] {0x01E1};
      case 0x1D5B4:
        return new int[] {0x0075};
      case 0x1D5B5:
        return new int[] {0x0076};
      case 0x01DE:
        return new int[] {0x01DF};
      case 0x1D5B8:
        return new int[] {0x0079};
      case 0x1D5B9:
        return new int[] {0x007A};
      case 0x01DB:
        return new int[] {0x01DC};
      case 0x01F7:
        return new int[] {0x01BF};
      case 0x01F8:
        return new int[] {0x01F9};
      case 0x01F6:
        return new int[] {0x0195};
      case 0x01F0:
        return new int[] {0x006A, 0x030C};
      case 0x01F4:
        return new int[] {0x01F5};
      case 0x01F1:
        return new int[] {0x01F3};
      case 0x01F2:
        return new int[] {0x01F3};
      case 0x01EE:
        return new int[] {0x01EF};
      case 0x01EC:
        return new int[] {0x01ED};
      case 0x01EA:
        return new int[] {0x01EB};
      case 0x01FE:
        return new int[] {0x01FF};
      case 0x01FC:
        return new int[] {0x01FD};
      case 0x01FA:
        return new int[] {0x01FB};
      case 0x1D5A1:
        return new int[] {0x0062};
      case 0x1D5A2:
        return new int[] {0x0063};
      case 0x1D5A0:
        return new int[] {0x0061};
      case 0x1D5A5:
        return new int[] {0x0066};
      case 0x1D5A6:
        return new int[] {0x0067};
      case 0x1D5A3:
        return new int[] {0x0064};
      case 0x1D5A4:
        return new int[] {0x0065};
      case 0x1D5A9:
        return new int[] {0x006A};
      case 0x1D5A7:
        return new int[] {0x0068};
      case 0x1D5A8:
        return new int[] {0x0069};
      case 0x1D5AA:
        return new int[] {0x006B};
      case 0x1D5AB:
        return new int[] {0x006C};
      case 0x1D5AE:
        return new int[] {0x006F};
      case 0x1D5AF:
        return new int[] {0x0070};
      case 0x1D5AC:
        return new int[] {0x006D};
      case 0x1D5AD:
        return new int[] {0x006E};
      case 0x01A2:
        return new int[] {0x01A3};
      case 0x03E4:
        return new int[] {0x03E5};
      case 0x1EEC:
        return new int[] {0x1EED};
      case 0x01A0:
        return new int[] {0x01A1};
      case 0x03E2:
        return new int[] {0x03E3};
      case 0x1EEA:
        return new int[] {0x1EEB};
      case 0x01A6:
        return new int[] {0x0280};
      case 0x03E8:
        return new int[] {0x03E9};
      case 0x01A7:
        return new int[] {0x01A8};
      case 0x01A4:
        return new int[] {0x01A5};
      case 0x03E6:
        return new int[] {0x03E7};
      case 0x1EEE:
        return new int[] {0x1EEF};
      case 0x03E0:
        return new int[] {0x03E1};
      case 0x03DC:
        return new int[] {0x03DD};
      case 0x1EE4:
        return new int[] {0x1EE5};
      case 0x03DA:
        return new int[] {0x03DB};
      case 0x1EE2:
        return new int[] {0x1EE3};
      case 0x1EE8:
        return new int[] {0x1EE9};
      case 0x03DE:
        return new int[] {0x03DF};
      case 0x1EE6:
        return new int[] {0x1EE7};
      case 0x1EE0:
        return new int[] {0x1EE1};
      case 0x1D7BB:
        return new int[] {0x03C3};
      case 0x01B3:
        return new int[] {0x01B4};
      case 0x03F5:
        return new int[] {0x03B5};
      case 0x01B1:
        return new int[] {0x028A};
      case 0x01B2:
        return new int[] {0x028B};
      case 0x03F4:
        return new int[] {0x03B8};
      case 0x01B7:
        return new int[] {0x0292};
      case 0x01B8:
        return new int[] {0x01B9};
      case 0x01B5:
        return new int[] {0x01B6};
      case 0x03F1:
        return new int[] {0x03C1};
      case 0x03F2:
        return new int[] {0x03C3};
      case 0x03F0:
        return new int[] {0x03BA};
      case 0x1EF4:
        return new int[] {0x1EF5};
      case 0x01AC:
        return new int[] {0x01AD};
      case 0x03EE:
        return new int[] {0x03EF};
      case 0x1EF2:
        return new int[] {0x1EF3};
      case 0x03EC:
        return new int[] {0x03ED};
      case 0x01AF:
        return new int[] {0x01B0};
      case 0x1EF8:
        return new int[] {0x1EF9};
      case 0x1EF6:
        return new int[] {0x1EF7};
      case 0x01AE:
        return new int[] {0x0288};
      case 0x01A9:
        return new int[] {0x0283};
      case 0x1EF0:
        return new int[] {0x1EF1};
      case 0x03EA:
        return new int[] {0x03EB};
      case 0x01C4:
        return new int[] {0x01C6};
      case 0x01C5:
        return new int[] {0x01C6};
      case 0x01C8:
        return new int[] {0x01C9};
      case 0x01C7:
        return new int[] {0x01C9};
      case 0x01BC:
        return new int[] {0x01BD};
      case 0x01D5:
        return new int[] {0x01D6};
      case 0x01D3:
        return new int[] {0x01D4};
      case 0x01D9:
        return new int[] {0x01DA};
      case 0x01D7:
        return new int[] {0x01D8};
      case 0x1D7A0:
        return new int[] {0x03C1};
      case 0x01D1:
        return new int[] {0x01D2};
      case 0x1D7A3:
        return new int[] {0x03C4};
      case 0x1D7A4:
        return new int[] {0x03C5};
      case 0x1D7A1:
        return new int[] {0x03B8};
      case 0x1D7A2:
        return new int[] {0x03C3};
      case 0x01CD:
        return new int[] {0x01CE};
      case 0x1D7A7:
        return new int[] {0x03C8};
      case 0x1D7A8:
        return new int[] {0x03C9};
      case 0x01CB:
        return new int[] {0x01CC};
      case 0x1D7A5:
        return new int[] {0x03C6};
      case 0x1D7A6:
        return new int[] {0x03C7};
      case 0x01CF:
        return new int[] {0x01D0};
      case 0x01CA:
        return new int[] {0x01CC};
      case 0x042A:
        return new int[] {0x044A};
      case 0x042D:
        return new int[] {0x044D};
      case 0x042E:
        return new int[] {0x044E};
      case 0x042B:
        return new int[] {0x044B};
      case 0x042C:
        return new int[] {0x044C};
      case 0x0428:
        return new int[] {0x0448};
      case 0x0429:
        return new int[] {0x0449};
      case 0x0426:
        return new int[] {0x0446};
      case 0x1F2E:
        return new int[] {0x1F26};
      case 0x0427:
        return new int[] {0x0447};
      case 0x1F2F:
        return new int[] {0x1F27};
      case 0x0420:
        return new int[] {0x0440};
      case 0x0421:
        return new int[] {0x0441};
      case 0x0424:
        return new int[] {0x0444};
      case 0x1F2C:
        return new int[] {0x1F24};
      case 0x0425:
        return new int[] {0x0445};
      case 0x1F2D:
        return new int[] {0x1F25};
      case 0x0422:
        return new int[] {0x0442};
      case 0x1F2A:
        return new int[] {0x1F22};
      case 0x0423:
        return new int[] {0x0443};
      case 0x1F2B:
        return new int[] {0x1F23};
      case 0x1F28:
        return new int[] {0x1F20};
      case 0x041E:
        return new int[] {0x043E};
      case 0x041F:
        return new int[] {0x043F};
      case 0x1F29:
        return new int[] {0x1F21};
      case 0x1F3F:
        return new int[] {0x1F37};
      case 0x1F3A:
        return new int[] {0x1F32};
      case 0x1F3D:
        return new int[] {0x1F35};
      case 0x1F3E:
        return new int[] {0x1F36};
      case 0x1F3B:
        return new int[] {0x1F33};
      case 0x1F3C:
        return new int[] {0x1F34};
      case 0x1F38:
        return new int[] {0x1F30};
      case 0x1F39:
        return new int[] {0x1F31};
      case 0x042F:
        return new int[] {0x044F};
      case 0x1F52:
        return new int[] {0x03C5, 0x0313, 0x0300};
      case 0x020A:
        return new int[] {0x020B};
      case 0x1F50:
        return new int[] {0x03C5, 0x0313};
      case 0x1F56:
        return new int[] {0x03C5, 0x0313, 0x0342};
      case 0x020E:
        return new int[] {0x020F};
      case 0x1F54:
        return new int[] {0x03C5, 0x0313, 0x0301};
      case 0x020C:
        return new int[] {0x020D};
      case 0x0208:
        return new int[] {0x0209};
      case 0x0206:
        return new int[] {0x0207};
      case 0x0200:
        return new int[] {0x0201};
      case 0x1F4A:
        return new int[] {0x1F42};
      case 0x1F4B:
        return new int[] {0x1F43};
      case 0x0204:
        return new int[] {0x0205};
      case 0x0202:
        return new int[] {0x0203};
      case 0x1F4C:
        return new int[] {0x1F44};
      case 0x1F4D:
        return new int[] {0x1F45};
      case 0x1F49:
        return new int[] {0x1F41};
      case 0x1F48:
        return new int[] {0x1F40};
      case 0x021A:
        return new int[] {0x021B};
      case 0x021E:
        return new int[] {0x021F};
      case 0x1F68:
        return new int[] {0x1F60};
      case 0x021C:
        return new int[] {0x021D};
      case 0x0218:
        return new int[] {0x0219};
      case 0x1F5B:
        return new int[] {0x1F53};
      case 0x0212:
        return new int[] {0x0213};
      case 0x0210:
        return new int[] {0x0211};
      case 0x1F5F:
        return new int[] {0x1F57};
      case 0x0216:
        return new int[] {0x0217};
      case 0x1F5D:
        return new int[] {0x1F55};
      case 0x0214:
        return new int[] {0x0215};
      case 0x1F59:
        return new int[] {0x1F51};
      case 0x040B:
        return new int[] {0x045B};
      case 0x040C:
        return new int[] {0x045C};
      case 0x040A:
        return new int[] {0x045A};
      case 0x0406:
        return new int[] {0x0456};
      case 0x1F0E:
        return new int[] {0x1F06};
      case 0x1D5D4:
        return new int[] {0x0061};
      case 0x0407:
        return new int[] {0x0457};
      case 0x1F0F:
        return new int[] {0x1F07};
      case 0x1D5D5:
        return new int[] {0x0062};
      case 0x0404:
        return new int[] {0x0454};
      case 0x1F0C:
        return new int[] {0x1F04};
      case 0x0405:
        return new int[] {0x0455};
      case 0x1F0D:
        return new int[] {0x1F05};
      case 0x1D5D8:
        return new int[] {0x0065};
      case 0x1D5D9:
        return new int[] {0x0066};
      case 0x0408:
        return new int[] {0x0458};
      case 0x1D5D6:
        return new int[] {0x0063};
      case 0x0409:
        return new int[] {0x0459};
      case 0x1D5D7:
        return new int[] {0x0064};
      case 0x0402:
        return new int[] {0x0452};
      case 0x1F0A:
        return new int[] {0x1F02};
      case 0x0403:
        return new int[] {0x0453};
      case 0x1F0B:
        return new int[] {0x1F03};
      case 0x1D5DA:
        return new int[] {0x0067};
      case 0x0400:
        return new int[] {0x0450};
      case 0x0401:
        return new int[] {0x0451};
      case 0x1D5DD:
        return new int[] {0x006A};
      case 0x1D5DE:
        return new int[] {0x006B};
      case 0x1D5DB:
        return new int[] {0x0068};
      case 0x1D5DC:
        return new int[] {0x0069};
      case 0x1F09:
        return new int[] {0x1F01};
      case 0x1D5DF:
        return new int[] {0x006C};
      case 0x1F08:
        return new int[] {0x1F00};
      case 0x041C:
        return new int[] {0x043C};
      case 0x1D5E1:
        return new int[] {0x006E};
      case 0x041D:
        return new int[] {0x043D};
      case 0x1D5E2:
        return new int[] {0x006F};
      case 0x041A:
        return new int[] {0x043A};
      case 0x041B:
        return new int[] {0x043B};
      case 0x1D5E0:
        return new int[] {0x006D};
      case 0x0417:
        return new int[] {0x0437};
      case 0x1D5E5:
        return new int[] {0x0072};
      case 0x0418:
        return new int[] {0x0438};
      case 0x1D5E6:
        return new int[] {0x0073};
      case 0x0415:
        return new int[] {0x0435};
      case 0x1F1D:
        return new int[] {0x1F15};
      case 0x1D5E3:
        return new int[] {0x0070};
      case 0x0416:
        return new int[] {0x0436};
      case 0x1D5E4:
        return new int[] {0x0071};
      case 0x1D5E9:
        return new int[] {0x0076};
      case 0x0419:
        return new int[] {0x0439};
      case 0x1D5E7:
        return new int[] {0x0074};
      case 0x1D5E8:
        return new int[] {0x0075};
      case 0x0410:
        return new int[] {0x0430};
      case 0x0413:
        return new int[] {0x0433};
      case 0x1F1B:
        return new int[] {0x1F13};
      case 0x1D5EA:
        return new int[] {0x0077};
      case 0x0414:
        return new int[] {0x0434};
      case 0x1F1C:
        return new int[] {0x1F14};
      case 0x1D5EB:
        return new int[] {0x0078};
      case 0x0411:
        return new int[] {0x0431};
      case 0x0412:
        return new int[] {0x0432};
      case 0x1F1A:
        return new int[] {0x1F12};
      case 0x040F:
        return new int[] {0x045F};
      case 0x040D:
        return new int[] {0x045D};
      case 0x1D5EC:
        return new int[] {0x0079};
      case 0x040E:
        return new int[] {0x045E};
      case 0x1D5ED:
        return new int[] {0x007A};
      case 0x1F18:
        return new int[] {0x1F10};
      case 0x1F19:
        return new int[] {0x1F11};
      case 0x1D519:
        return new int[] {0x0076};
      case 0x1D517:
        return new int[] {0x0074};
      case 0x1D759:
        return new int[] {0x03B4};
      case 0x1D518:
        return new int[] {0x0075};
      case 0x1D51A:
        return new int[] {0x0077};
      case 0x1D75C:
        return new int[] {0x03B7};
      case 0x1D51B:
        return new int[] {0x0078};
      case 0x1D75D:
        return new int[] {0x03B8};
      case 0x1D75A:
        return new int[] {0x03B5};
      case 0x1D75B:
        return new int[] {0x03B6};
      case 0x1D51C:
        return new int[] {0x0079};
      case 0x1D75E:
        return new int[] {0x03B9};
      case 0x1D75F:
        return new int[] {0x03BA};
      case 0x1D760:
        return new int[] {0x03BB};
      case 0x1D761:
        return new int[] {0x03BC};
      case 0x1D764:
        return new int[] {0x03BF};
      case 0x1D765:
        return new int[] {0x03C0};
      case 0x1D762:
        return new int[] {0x03BD};
      case 0x1D763:
        return new int[] {0x03BE};
      case 0x1D768:
        return new int[] {0x03C3};
      case 0x1D769:
        return new int[] {0x03C4};
      case 0x1D766:
        return new int[] {0x03C1};
      case 0x1D767:
        return new int[] {0x03B8};
      case 0x1D76A:
        return new int[] {0x03C5};
      case 0x1D76D:
        return new int[] {0x03C8};
      case 0x1D76E:
        return new int[] {0x03C9};
      case 0x1D76B:
        return new int[] {0x03C6};
      case 0x1D76C:
        return new int[] {0x03C7};
      case 0x1D538:
        return new int[] {0x0061};
      case 0x004F:
        return new int[] {0x006F};
      case 0x004D:
        return new int[] {0x006D};
      case 0x004E:
        return new int[] {0x006E};
      case 0x004B:
        return new int[] {0x006B};
      case 0x004C:
        return new int[] {0x006C};
      case 0x004A:
        return new int[] {0x006A};
      case 0x0046:
        return new int[] {0x0066};
      case 0x0047:
        return new int[] {0x0067};
      case 0x0044:
        return new int[] {0x0064};
      case 0x0045:
        return new int[] {0x0065};
      case 0x0048:
        return new int[] {0x0068};
      case 0x0049:
        return new int[] {0x0069};
      case 0x0042:
        return new int[] {0x0062};
      case 0x1D504:
        return new int[] {0x0061};
      case 0x0043:
        return new int[] {0x0063};
      case 0x1D505:
        return new int[] {0x0062};
      case 0x1D747:
        return new int[] {0x03C3};
      case 0x0041:
        return new int[] {0x0061};
      case 0x1D508:
        return new int[] {0x0065};
      case 0x1D509:
        return new int[] {0x0066};
      case 0x1D507:
        return new int[] {0x0064};
      case 0x1D50A:
        return new int[] {0x0067};
      case 0x1D50D:
        return new int[] {0x006A};
      case 0x1D50E:
        return new int[] {0x006B};
      case 0x005A:
        return new int[] {0x007A};
      case 0x0057:
        return new int[] {0x0077};
      case 0x0058:
        return new int[] {0x0078};
      case 0x0055:
        return new int[] {0x0075};
      case 0x1D50F:
        return new int[] {0x006C};
      case 0x0056:
        return new int[] {0x0076};
      case 0x0059:
        return new int[] {0x0079};
      case 0x1D511:
        return new int[] {0x006E};
      case 0x0050:
        return new int[] {0x0070};
      case 0x1D512:
        return new int[] {0x006F};
      case 0x1D510:
        return new int[] {0x006D};
      case 0x0053:
        return new int[] {0x0073};
      case 0x1D757:
        return new int[] {0x03B2};
      case 0x0054:
        return new int[] {0x0074};
      case 0x1D516:
        return new int[] {0x0073};
      case 0x1D758:
        return new int[] {0x03B3};
      case 0x0051:
        return new int[] {0x0071};
      case 0x1D513:
        return new int[] {0x0070};
      case 0x0052:
        return new int[] {0x0072};
      case 0x1D514:
        return new int[] {0x0071};
      case 0x1D756:
        return new int[] {0x03B1};
      case 0x022C:
        return new int[] {0x022D};
      case 0x046E:
        return new int[] {0x046F};
      case 0x022A:
        return new int[] {0x022B};
      case 0x046C:
        return new int[] {0x046D};
      case 0x022E:
        return new int[] {0x022F};
      case 0x0228:
        return new int[] {0x0229};
      case 0x1D71C:
        return new int[] {0x03B1};
      case 0x046A:
        return new int[] {0x046B};
      case 0x1D71D:
        return new int[] {0x03B2};
      case 0x0222:
        return new int[] {0x0223};
      case 0x0464:
        return new int[] {0x0465};
      case 0x1F6C:
        return new int[] {0x1F64};
      case 0x1F6D:
        return new int[] {0x1F65};
      case 0x0220:
        return new int[] {0x019E};
      case 0x0462:
        return new int[] {0x0463};
      case 0x1F6A:
        return new int[] {0x1F62};
      case 0x1D71E:
        return new int[] {0x03B3};
      case 0x1F6B:
        return new int[] {0x1F63};
      case 0x1D71F:
        return new int[] {0x03B4};
      case 0x0226:
        return new int[] {0x0227};
      case 0x0468:
        return new int[] {0x0469};
      case 0x0224:
        return new int[] {0x0225};
      case 0x0466:
        return new int[] {0x0467};
      case 0x1F6E:
        return new int[] {0x1F66};
      case 0x1F6F:
        return new int[] {0x1F67};
      case 0x1D720:
        return new int[] {0x03B5};
      case 0x1D721:
        return new int[] {0x03B6};
      case 0x1F69:
        return new int[] {0x1F61};
      case 0x0460:
        return new int[] {0x0461};
      case 0x1D724:
        return new int[] {0x03B9};
      case 0x1D725:
        return new int[] {0x03BA};
      case 0x1D722:
        return new int[] {0x03B7};
      case 0x1D723:
        return new int[] {0x03B8};
      case 0x047E:
        return new int[] {0x047F};
      case 0x1F85:
        return new int[] {0x1F05, 0x03B9};
      case 0x1D728:
        return new int[] {0x03BD};
      case 0x1F86:
        return new int[] {0x1F06, 0x03B9};
      case 0x1D729:
        return new int[] {0x03BE};
      case 0x047C:
        return new int[] {0x047D};
      case 0x1F83:
        return new int[] {0x1F03, 0x03B9};
      case 0x1D726:
        return new int[] {0x03BB};
      case 0x1F84:
        return new int[] {0x1F04, 0x03B9};
      case 0x1D727:
        return new int[] {0x03BC};
      case 0x1F89:
        return new int[] {0x1F01, 0x03B9};
      case 0x1F87:
        return new int[] {0x1F07, 0x03B9};
      case 0x1F88:
        return new int[] {0x1F00, 0x03B9};
      case 0x1D72A:
        return new int[] {0x03BF};
      case 0x047A:
        return new int[] {0x047B};
      case 0x1F81:
        return new int[] {0x1F01, 0x03B9};
      case 0x1D72D:
        return new int[] {0x03B8};
      case 0x1F82:
        return new int[] {0x1F02, 0x03B9};
      case 0x1D72E:
        return new int[] {0x03C3};
      case 0x1D72B:
        return new int[] {0x03C0};
      case 0x1F80:
        return new int[] {0x1F00, 0x03B9};
      case 0x1D72C:
        return new int[] {0x03C1};
      case 0x0476:
        return new int[] {0x0477};
      case 0x1D72F:
        return new int[] {0x03C4};
      case 0x0232:
        return new int[] {0x0233};
      case 0x0474:
        return new int[] {0x0475};
      case 0x0478:
        return new int[] {0x0479};
      case 0x1D731:
        return new int[] {0x03C6};
      case 0x1D732:
        return new int[] {0x03C7};
      case 0x1D730:
        return new int[] {0x03C5};
      case 0x0230:
        return new int[] {0x0231};
      case 0x0472:
        return new int[] {0x0473};
      case 0x1D733:
        return new int[] {0x03C8};
      case 0x0470:
        return new int[] {0x0471};
      case 0x1D734:
        return new int[] {0x03C9};
      case 0x1F96:
        return new int[] {0x1F26, 0x03B9};
      case 0x1F97:
        return new int[] {0x1F27, 0x03B9};
      case 0x1F94:
        return new int[] {0x1F24, 0x03B9};
      case 0x048E:
        return new int[] {0x048F};
      case 0x1F95:
        return new int[] {0x1F25, 0x03B9};
      case 0x1F98:
        return new int[] {0x1F20, 0x03B9};
      case 0x1F99:
        return new int[] {0x1F21, 0x03B9};
      case 0x1F92:
        return new int[] {0x1F22, 0x03B9};
      case 0x048C:
        return new int[] {0x048D};
      case 0x1F93:
        return new int[] {0x1F23, 0x03B9};
      case 0x1F90:
        return new int[] {0x1F20, 0x03B9};
      case 0x048A:
        return new int[] {0x048B};
      case 0x1F91:
        return new int[] {0x1F21, 0x03B9};
      case 0x1F8E:
        return new int[] {0x1F06, 0x03B9};
      case 0x1F8F:
        return new int[] {0x1F07, 0x03B9};
      case 0x1F8C:
        return new int[] {0x1F04, 0x03B9};
      case 0x1F8D:
        return new int[] {0x1F05, 0x03B9};
      case 0x1F8A:
        return new int[] {0x1F02, 0x03B9};
      case 0x1F8B:
        return new int[] {0x1F03, 0x03B9};
      case 0x0480:
        return new int[] {0x0481};
      case 0x049E:
        return new int[] {0x049F};
      case 0x049C:
        return new int[] {0x049D};
      case 0x049A:
        return new int[] {0x049B};
      case 0x1F9F:
        return new int[] {0x1F27, 0x03B9};
      case 0x0498:
        return new int[] {0x0499};
      case 0x1F9D:
        return new int[] {0x1F25, 0x03B9};
      case 0x1D70D:
        return new int[] {0x03C3};
      case 0x0496:
        return new int[] {0x0497};
      case 0x1F9E:
        return new int[] {0x1F26, 0x03B9};
      case 0x0490:
        return new int[] {0x0491};
      case 0x1F9B:
        return new int[] {0x1F23, 0x03B9};
      case 0x0494:
        return new int[] {0x0495};
      case 0x1F9C:
        return new int[] {0x1F24, 0x03B9};
      case 0x0492:
        return new int[] {0x0493};
      case 0x1F9A:
        return new int[] {0x1F22, 0x03B9};
      case 0x04C1:
        return new int[] {0x04C2};
      case 0x1FCA:
        return new int[] {0x1F74};
      case 0x04C5:
        return new int[] {0x04C6};
      case 0x04C3:
        return new int[] {0x04C4};
      case 0x1FCB:
        return new int[] {0x1F75};
      case 0x1FCC:
        return new int[] {0x03B7, 0x03B9};
      case 0x1FC8:
        return new int[] {0x1F72};
      case 0x1FC9:
        return new int[] {0x1F73};
      case 0x1FC6:
        return new int[] {0x03B7, 0x0342};
      case 0x1FC7:
        return new int[] {0x03B7, 0x0342, 0x03B9};
      case 0x04BA:
        return new int[] {0x04BB};
      case 0x1FC4:
        return new int[] {0x03AE, 0x03B9};
      case 0x04BE:
        return new int[] {0x04BF};
      case 0x1FC2:
        return new int[] {0x1F74, 0x03B9};
      case 0x04BC:
        return new int[] {0x04BD};
      case 0x1FC3:
        return new int[] {0x03B7, 0x03B9};
      case 0x04B8:
        return new int[] {0x04B9};
      case 0x3371:
        return new int[] {0x0068, 0x0070, 0x0061};
      case 0x04B6:
        return new int[] {0x04B7};
      case 0x1FBE:
        return new int[] {0x03B9};
      case 0x3375:
        return new int[] {0x006F, 0x0076};
      case 0x3373:
        return new int[] {0x0061, 0x0075};
      case 0x04D2:
        return new int[] {0x04D3};
      case 0x1FDA:
        return new int[] {0x1F76};
      case 0x1FDB:
        return new int[] {0x1F77};
      case 0x04D0:
        return new int[] {0x04D1};
      case 0x04D6:
        return new int[] {0x04D7};
      case 0x3390:
        return new int[] {0x0068, 0x007A};
      case 0x04D4:
        return new int[] {0x04D5};
      case 0x1FD9:
        return new int[] {0x1FD1};
      case 0x338C:
        return new int[] {0x03BC, 0x0066};
      case 0x338B:
        return new int[] {0x006E, 0x0066};
      case 0x1FD7:
        return new int[] {0x03B9, 0x0308, 0x0342};
      case 0x338A:
        return new int[] {0x0070, 0x0066};
      case 0x1FD8:
        return new int[] {0x1FD0};
      case 0x04CB:
        return new int[] {0x04CC};
      case 0x1FD2:
        return new int[] {0x03B9, 0x0308, 0x0300};
      case 0x1FD6:
        return new int[] {0x03B9, 0x0342};
      case 0x1FD3:
        return new int[] {0x03B9, 0x0308, 0x0301};
      case 0x04CD:
        return new int[] {0x04CE};
      case 0x04C9:
        return new int[] {0x04CA};
      case 0x3383:
        return new int[] {0x006D, 0x0061};
      case 0x3382:
        return new int[] {0x03BC, 0x0061};
      case 0x04C7:
        return new int[] {0x04C8};
      case 0x3381:
        return new int[] {0x006E, 0x0061};
      case 0x3380:
        return new int[] {0x0070, 0x0061};
      case 0x3387:
        return new int[] {0x0067, 0x0062};
      case 0x3386:
        return new int[] {0x006D, 0x0062};
      case 0x3385:
        return new int[] {0x006B, 0x0062};
      case 0x3384:
        return new int[] {0x006B, 0x0061};
      case 0x1FEB:
        return new int[] {0x1F7B};
      case 0x04E4:
        return new int[] {0x04E5};
      case 0x1FEC:
        return new int[] {0x1FE5};
      case 0x04E2:
        return new int[] {0x04E3};
      case 0x1FEA:
        return new int[] {0x1F7A};
      case 0x1D57C:
        return new int[] {0x0071};
      case 0x04E8:
        return new int[] {0x04E9};
      case 0x1D57D:
        return new int[] {0x0072};
      case 0x1D57A:
        return new int[] {0x006F};
      case 0x04E6:
        return new int[] {0x04E7};
      case 0x1D57B:
        return new int[] {0x0070};
      case 0x1FE8:
        return new int[] {0x1FE0};
      case 0x1D57E:
        return new int[] {0x0073};
      case 0x1FE9:
        return new int[] {0x1FE1};
      case 0x1D57F:
        return new int[] {0x0074};
      case 0x04E0:
        return new int[] {0x04E1};
      case 0x1FE2:
        return new int[] {0x03C5, 0x0308, 0x0300};
      case 0x1D580:
        return new int[] {0x0075};
      case 0x04DC:
        return new int[] {0x04DD};
      case 0x1FE3:
        return new int[] {0x03C5, 0x0308, 0x0301};
      case 0x1D581:
        return new int[] {0x0076};
      case 0x04DA:
        return new int[] {0x04DB};
      case 0x1FE6:
        return new int[] {0x03C5, 0x0342};
      case 0x1D584:
        return new int[] {0x0079};
      case 0x1FE7:
        return new int[] {0x03C5, 0x0308, 0x0342};
      case 0x1D585:
        return new int[] {0x007A};
      case 0x1FE4:
        return new int[] {0x03C1, 0x0313};
      case 0x1D582:
        return new int[] {0x0077};
      case 0x04DE:
        return new int[] {0x04DF};
      case 0x1D583:
        return new int[] {0x0078};
      case 0x3394:
        return new int[] {0x0074, 0x0068, 0x007A};
      case 0x3393:
        return new int[] {0x0067, 0x0068, 0x007A};
      case 0x04D8:
        return new int[] {0x04D9};
      case 0x3392:
        return new int[] {0x006D, 0x0068, 0x007A};
      case 0x3391:
        return new int[] {0x006B, 0x0068, 0x007A};
      case 0x04F4:
        return new int[] {0x04F5};
      case 0x1FFC:
        return new int[] {0x03C9, 0x03B9};
      case 0x04F2:
        return new int[] {0x04F3};
      case 0x1FFA:
        return new int[] {0x1F7C};
      case 0x1FFB:
        return new int[] {0x1F7D};
      case 0x04F8:
        return new int[] {0x04F9};
      case 0x1FF9:
        return new int[] {0x1F79};
      case 0x04F0:
        return new int[] {0x04F1};
      case 0x04EC:
        return new int[] {0x04ED};
      case 0x1FF3:
        return new int[] {0x03C9, 0x03B9};
      case 0x1FF4:
        return new int[] {0x03CE, 0x03B9};
      case 0x04EA:
        return new int[] {0x04EB};
      case 0x1FF2:
        return new int[] {0x1F7C, 0x03B9};
      case 0x1FF7:
        return new int[] {0x03C9, 0x0342, 0x03B9};
      case 0x1FF8:
        return new int[] {0x1F78};
      case 0x04EE:
        return new int[] {0x04EF};
      case 0x1FF6:
        return new int[] {0x03C9, 0x0342};
      case 0x1D79C:
        return new int[] {0x03BD};
      case 0x1D79D:
        return new int[] {0x03BE};
      case 0x1D79A:
        return new int[] {0x03BB};
      case 0x1D79B:
        return new int[] {0x03BC};
      case 0x1D79E:
        return new int[] {0x03BF};
      case 0x1D79F:
        return new int[] {0x03C0};
      case 0x1D56C:
        return new int[] {0x0061};
      case 0x1D56F:
        return new int[] {0x0064};
      case 0x1D56D:
        return new int[] {0x0062};
      case 0x1D56E:
        return new int[] {0x0063};
      case 0x1D570:
        return new int[] {0x0065};
      case 0x1D573:
        return new int[] {0x0068};
      case 0x1D574:
        return new int[] {0x0069};
      case 0x1D571:
        return new int[] {0x0066};
      case 0x1D572:
        return new int[] {0x0067};
      case 0x1D577:
        return new int[] {0x006C};
      case 0x1D578:
        return new int[] {0x006D};
      case 0x1D575:
        return new int[] {0x006A};
      case 0x1D576:
        return new int[] {0x006B};
      case 0x1D579:
        return new int[] {0x006E};
      case 0x04A0:
        return new int[] {0x04A1};
      case 0x1D539:
        return new int[] {0x0062};
      case 0x1FAB:
        return new int[] {0x1F63, 0x03B9};
      case 0x04A4:
        return new int[] {0x04A5};
      case 0x1FAC:
        return new int[] {0x1F64, 0x03B9};
      case 0x04A2:
        return new int[] {0x04A3};
      case 0x1FAA:
        return new int[] {0x1F62, 0x03B9};
      case 0x1FA6:
        return new int[] {0x1F66, 0x03B9};
      case 0x1D53C:
        return new int[] {0x0065};
      case 0x1FA7:
        return new int[] {0x1F67, 0x03B9};
      case 0x1D53D:
        return new int[] {0x0066};
      case 0x1FA4:
        return new int[] {0x1F64, 0x03B9};
      case 0x1FA5:
        return new int[] {0x1F65, 0x03B9};
      case 0x1D53B:
        return new int[] {0x0064};
      case 0x1FA8:
        return new int[] {0x1F60, 0x03B9};
      case 0x1D53E:
        return new int[] {0x0067};
      case 0x1FA9:
        return new int[] {0x1F61, 0x03B9};
      case 0x1FA2:
        return new int[] {0x1F62, 0x03B9};
      case 0x1D540:
        return new int[] {0x0069};
      case 0x1FA3:
        return new int[] {0x1F63, 0x03B9};
      case 0x1D541:
        return new int[] {0x006A};
      case 0x1FA0:
        return new int[] {0x1F60, 0x03B9};
      case 0x1FA1:
        return new int[] {0x1F61, 0x03B9};
      case 0x1D781:
        return new int[] {0x03C3};
      case 0x1D544:
        return new int[] {0x006D};
      case 0x1D542:
        return new int[] {0x006B};
      case 0x1D543:
        return new int[] {0x006C};
      case 0x1D546:
        return new int[] {0x006F};
      case 0x04B0:
        return new int[] {0x04B1};
      case 0x04B4:
        return new int[] {0x04B5};
      case 0x1FBC:
        return new int[] {0x03B1, 0x03B9};
      case 0x1D54A:
        return new int[] {0x0073};
      case 0x04B2:
        return new int[] {0x04B3};
      case 0x1FBA:
        return new int[] {0x1F70};
      case 0x1FBB:
        return new int[] {0x1F71};
      case 0x1FB7:
        return new int[] {0x03B1, 0x0342, 0x03B9};
      case 0x1D54D:
        return new int[] {0x0076};
      case 0x1FB8:
        return new int[] {0x1FB0};
      case 0x1D54E:
        return new int[] {0x0077};
      case 0x04AE:
        return new int[] {0x04AF};
      case 0x1D54B:
        return new int[] {0x0074};
      case 0x1FB6:
        return new int[] {0x03B1, 0x0342};
      case 0x1D54C:
        return new int[] {0x0075};
      case 0x1FB9:
        return new int[] {0x1FB1};
      case 0x1D54F:
        return new int[] {0x0078};
      case 0x1D790:
        return new int[] {0x03B1};
      case 0x04AC:
        return new int[] {0x04AD};
      case 0x1FB3:
        return new int[] {0x03B1, 0x03B9};
      case 0x1D793:
        return new int[] {0x03B4};
      case 0x1FB4:
        return new int[] {0x03AC, 0x03B9};
      case 0x1D794:
        return new int[] {0x03B5};
      case 0x04AA:
        return new int[] {0x04AB};
      case 0x1D791:
        return new int[] {0x03B2};
      case 0x1FB2:
        return new int[] {0x1F70, 0x03B9};
      case 0x1D550:
        return new int[] {0x0079};
      case 0x1D792:
        return new int[] {0x03B3};
      case 0x1FAF:
        return new int[] {0x1F67, 0x03B9};
      case 0x1D797:
        return new int[] {0x03B8};
      case 0x04A8:
        return new int[] {0x04A9};
      case 0x1D798:
        return new int[] {0x03B9};
      case 0x1FAD:
        return new int[] {0x1F65, 0x03B9};
      case 0x1D795:
        return new int[] {0x03B6};
      case 0x04A6:
        return new int[] {0x04A7};
      case 0x1FAE:
        return new int[] {0x1F66, 0x03B9};
      case 0x1D796:
        return new int[] {0x03B7};
      case 0x1D799:
        return new int[] {0x03BA};
      default:
        return new int[] {codePoint};
    }
  }

  /**
   * Mapping for case-folding used with no normalization.
   *
   * @param codePoint the character (Unicode code point) to be mapped.
   * @return  Case-folding used with no normalization for the given {@code codePoint}.
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-B.3">RFC 3454, Appendix B.3</a>
   */
  public static int[] mapWithoutNormalization(int codePoint) {
    switch (codePoint) {
      case 0x00C5:
        return new int[] {0x00E5};
      case 0x00C6:
        return new int[] {0x00E6};
      case 0x00C3:
        return new int[] {0x00E3};
      case 0x00C4:
        return new int[] {0x00E4};
      case 0x00C9:
        return new int[] {0x00E9};
      case 0x00C7:
        return new int[] {0x00E7};
      case 0x00C8:
        return new int[] {0x00E8};
      case 0x00C1:
        return new int[] {0x00E1};
      case 0x00C2:
        return new int[] {0x00E2};
      case 0x00C0:
        return new int[] {0x00E0};
      case 0x00D6:
        return new int[] {0x00F6};
      case 0x00D4:
        return new int[] {0x00F4};
      case 0x00D5:
        return new int[] {0x00F5};
      case 0x00D8:
        return new int[] {0x00F8};
      case 0x00D9:
        return new int[] {0x00F9};
      case 0x00D2:
        return new int[] {0x00F2};
      case 0x00D3:
        return new int[] {0x00F3};
      case 0x00D0:
        return new int[] {0x00F0};
      case 0x00D1:
        return new int[] {0x00F1};
      case 0x00CE:
        return new int[] {0x00EE};
      case 0x00CF:
        return new int[] {0x00EF};
      case 0x00CC:
        return new int[] {0x00EC};
      case 0x00CD:
        return new int[] {0x00ED};
      case 0x00CA:
        return new int[] {0x00EA};
      case 0x00CB:
        return new int[] {0x00EB};
      case 0x00DF:
        return new int[] {0x0073, 0x0073};
      case 0x00DD:
        return new int[] {0x00FD};
      case 0x00DE:
        return new int[] {0x00FE};
      case 0x00DB:
        return new int[] {0x00FB};
      case 0x00DC:
        return new int[] {0x00FC};
      case 0x00DA:
        return new int[] {0x00FA};
      case 0x24B7:
        return new int[] {0x24D1};
      case 0x24B6:
        return new int[] {0x24D0};
      case 0x24C4:
        return new int[] {0x24DE};
      case 0x24C3:
        return new int[] {0x24DD};
      case 0x24C2:
        return new int[] {0x24DC};
      case 0x24C1:
        return new int[] {0x24DB};
      case 0x24C8:
        return new int[] {0x24E2};
      case 0x24C7:
        return new int[] {0x24E1};
      case 0x24C6:
        return new int[] {0x24E0};
      case 0x24C5:
        return new int[] {0x24DF};
      case 0x24C0:
        return new int[] {0x24DA};
      case 0x24BC:
        return new int[] {0x24D6};
      case 0x24BB:
        return new int[] {0x24D5};
      case 0x24BA:
        return new int[] {0x24D4};
      case 0x24BF:
        return new int[] {0x24D9};
      case 0x24BE:
        return new int[] {0x24D8};
      case 0x24BD:
        return new int[] {0x24D7};
      case 0x24B9:
        return new int[] {0x24D3};
      case 0x24B8:
        return new int[] {0x24D2};
      case 0x00B5:
        return new int[] {0x03BC};
      case 0x24CD:
        return new int[] {0x24E7};
      case 0x24CC:
        return new int[] {0x24E6};
      case 0x24CB:
        return new int[] {0x24E5};
      case 0x24CA:
        return new int[] {0x24E4};
      case 0x24CF:
        return new int[] {0x24E9};
      case 0x24CE:
        return new int[] {0x24E8};
      case 0x24C9:
        return new int[] {0x24E3};
      case 0x054A:
        return new int[] {0x057A};
      case 0x054B:
        return new int[] {0x057B};
      case 0x1E10:
        return new int[] {0x1E11};
      case 0x054E:
        return new int[] {0x057E};
      case 0x054F:
        return new int[] {0x057F};
      case 0x1E14:
        return new int[] {0x1E15};
      case 0x054C:
        return new int[] {0x057C};
      case 0x054D:
        return new int[] {0x057D};
      case 0x1E12:
        return new int[] {0x1E13};
      case 0x0549:
        return new int[] {0x0579};
      case 0x0547:
        return new int[] {0x0577};
      case 0x0548:
        return new int[] {0x0578};
      case 0x1E0E:
        return new int[] {0x1E0F};
      case 0x0541:
        return new int[] {0x0571};
      case 0x0542:
        return new int[] {0x0572};
      case 0x0540:
        return new int[] {0x0570};
      case 0x0545:
        return new int[] {0x0575};
      case 0x0546:
        return new int[] {0x0576};
      case 0x1E0C:
        return new int[] {0x1E0D};
      case 0x0543:
        return new int[] {0x0573};
      case 0x0544:
        return new int[] {0x0574};
      case 0x1E0A:
        return new int[] {0x1E0B};
      case 0x1E06:
        return new int[] {0x1E07};
      case 0x053F:
        return new int[] {0x056F};
      case 0x1E04:
        return new int[] {0x1E05};
      case 0x1E08:
        return new int[] {0x1E09};
      case 0x1E20:
        return new int[] {0x1E21};
      case 0x1E24:
        return new int[] {0x1E25};
      case 0x1E22:
        return new int[] {0x1E23};
      case 0x1E1E:
        return new int[] {0x1E1F};
      case 0x0552:
        return new int[] {0x0582};
      case 0x0553:
        return new int[] {0x0583};
      case 0x0550:
        return new int[] {0x0580};
      case 0x0551:
        return new int[] {0x0581};
      case 0x0556:
        return new int[] {0x0586};
      case 0x1E1C:
        return new int[] {0x1E1D};
      case 0x0554:
        return new int[] {0x0584};
      case 0x1E1A:
        return new int[] {0x1E1B};
      case 0x0555:
        return new int[] {0x0585};
      case 0x1E18:
        return new int[] {0x1E19};
      case 0x1E16:
        return new int[] {0x1E17};
      case 0x1E32:
        return new int[] {0x1E33};
      case 0x1E30:
        return new int[] {0x1E31};
      case 0x1E36:
        return new int[] {0x1E37};
      case 0x1E34:
        return new int[] {0x1E35};
      case 0x1E2A:
        return new int[] {0x1E2B};
      case 0x1E2E:
        return new int[] {0x1E2F};
      case 0x1E2C:
        return new int[] {0x1E2D};
      case 0x1E28:
        return new int[] {0x1E29};
      case 0x1E26:
        return new int[] {0x1E27};
      case 0x1E42:
        return new int[] {0x1E43};
      case 0x1E40:
        return new int[] {0x1E41};
      case 0x1E46:
        return new int[] {0x1E47};
      case 0x1E44:
        return new int[] {0x1E45};
      case 0x1E3A:
        return new int[] {0x1E3B};
      case 0x1E3E:
        return new int[] {0x1E3F};
      case 0x1E3C:
        return new int[] {0x1E3D};
      case 0x1E38:
        return new int[] {0x1E39};
      case 0x050A:
        return new int[] {0x050B};
      case 0x0506:
        return new int[] {0x0507};
      case 0x0504:
        return new int[] {0x0505};
      case 0x0508:
        return new int[] {0x0509};
      case 0x0502:
        return new int[] {0x0503};
      case 0x0500:
        return new int[] {0x0501};
      case 0x050E:
        return new int[] {0x050F};
      case 0x050C:
        return new int[] {0x050D};
      case 0xFF30:
        return new int[] {0xFF50};
      case 0xFF31:
        return new int[] {0xFF51};
      case 0xFF32:
        return new int[] {0xFF52};
      case 0xFF37:
        return new int[] {0xFF57};
      case 0xFF38:
        return new int[] {0xFF58};
      case 0xFF39:
        return new int[] {0xFF59};
      case 0xFF33:
        return new int[] {0xFF53};
      case 0xFF34:
        return new int[] {0xFF54};
      case 0xFF35:
        return new int[] {0xFF55};
      case 0xFF36:
        return new int[] {0xFF56};
      case 0xFF3A:
        return new int[] {0xFF5A};
      case 0x053A:
        return new int[] {0x056A};
      case 0xFF21:
        return new int[] {0xFF41};
      case 0x053D:
        return new int[] {0x056D};
      case 0x1E02:
        return new int[] {0x1E03};
      case 0x053E:
        return new int[] {0x056E};
      case 0x053B:
        return new int[] {0x056B};
      case 0x1E00:
        return new int[] {0x1E01};
      case 0x053C:
        return new int[] {0x056C};
      case 0x0538:
        return new int[] {0x0568};
      case 0xFF26:
        return new int[] {0xFF46};
      case 0x0539:
        return new int[] {0x0569};
      case 0xFF27:
        return new int[] {0xFF47};
      case 0x0536:
        return new int[] {0x0566};
      case 0xFF28:
        return new int[] {0xFF48};
      case 0x0537:
        return new int[] {0x0567};
      case 0xFF29:
        return new int[] {0xFF49};
      case 0xFF22:
        return new int[] {0xFF42};
      case 0xFF23:
        return new int[] {0xFF43};
      case 0xFF24:
        return new int[] {0xFF44};
      case 0xFF25:
        return new int[] {0xFF45};
      case 0x0531:
        return new int[] {0x0561};
      case 0xFF2A:
        return new int[] {0xFF4A};
      case 0x0534:
        return new int[] {0x0564};
      case 0x0535:
        return new int[] {0x0565};
      case 0x0532:
        return new int[] {0x0562};
      case 0x0533:
        return new int[] {0x0563};
      case 0xFF2F:
        return new int[] {0xFF4F};
      case 0xFF2B:
        return new int[] {0xFF4B};
      case 0xFF2C:
        return new int[] {0xFF4C};
      case 0xFF2D:
        return new int[] {0xFF4D};
      case 0xFF2E:
        return new int[] {0xFF4E};
      case 0x014E:
        return new int[] {0x014F};
      case 0x1E97:
        return new int[] {0x0074, 0x0308};
      case 0x1E98:
        return new int[] {0x0077, 0x030A};
      case 0x014C:
        return new int[] {0x014D};
      case 0x038E:
        return new int[] {0x03CD};
      case 0x038F:
        return new int[] {0x03CE};
      case 0x1E96:
        return new int[] {0x0068, 0x0331};
      case 0x1E99:
        return new int[] {0x0079, 0x030A};
      case 0x1E90:
        return new int[] {0x1E91};
      case 0x014A:
        return new int[] {0x014B};
      case 0x038C:
        return new int[] {0x03CC};
      case 0x1E94:
        return new int[] {0x1E95};
      case 0x038A:
        return new int[] {0x03AF};
      case 0x1E92:
        return new int[] {0x1E93};
      case 0x0145:
        return new int[] {0x0146};
      case 0x0388:
        return new int[] {0x03AD};
      case 0x0143:
        return new int[] {0x0144};
      case 0x0386:
        return new int[] {0x03AC};
      case 0x1E8E:
        return new int[] {0x1E8F};
      case 0x0149:
        return new int[] {0x02BC, 0x006E};
      case 0x0147:
        return new int[] {0x0148};
      case 0x0389:
        return new int[] {0x03AE};
      case 0x0141:
        return new int[] {0x0142};
      case 0x1E8C:
        return new int[] {0x1E8D};
      case 0x1E8A:
        return new int[] {0x1E8B};
      case 0x039F:
        return new int[] {0x03BF};
      case 0x015E:
        return new int[] {0x015F};
      case 0x039A:
        return new int[] {0x03BA};
      case 0x039D:
        return new int[] {0x03BD};
      case 0x015C:
        return new int[] {0x015D};
      case 0x039E:
        return new int[] {0x03BE};
      case 0x039B:
        return new int[] {0x03BB};
      case 0x015A:
        return new int[] {0x015B};
      case 0x039C:
        return new int[] {0x03BC};
      case 0x0156:
        return new int[] {0x0157};
      case 0x0398:
        return new int[] {0x03B8};
      case 0x0399:
        return new int[] {0x03B9};
      case 0x0154:
        return new int[] {0x0155};
      case 0x0396:
        return new int[] {0x03B6};
      case 0x0397:
        return new int[] {0x03B7};
      case 0x0158:
        return new int[] {0x0159};
      case 0x0390:
        return new int[] {0x03B9, 0x0308, 0x0301};
      case 0x0391:
        return new int[] {0x03B1};
      case 0x0152:
        return new int[] {0x0153};
      case 0x0394:
        return new int[] {0x03B4};
      case 0x0395:
        return new int[] {0x03B5};
      case 0x0150:
        return new int[] {0x0151};
      case 0x0392:
        return new int[] {0x03B2};
      case 0x1E9A:
        return new int[] {0x0061, 0x02BE};
      case 0x0393:
        return new int[] {0x03B3};
      case 0x1E9B:
        return new int[] {0x1E61};
      case 0x016E:
        return new int[] {0x016F};
      case 0x016C:
        return new int[] {0x016D};
      case 0x016A:
        return new int[] {0x016B};
      case 0x0168:
        return new int[] {0x0169};
      case 0x0166:
        return new int[] {0x0167};
      case 0x0160:
        return new int[] {0x0161};
      case 0x0164:
        return new int[] {0x0165};
      case 0x0162:
        return new int[] {0x0163};
      case 0x017F:
        return new int[] {0x0073};
      case 0x017D:
        return new int[] {0x017E};
      case 0x017B:
        return new int[] {0x017C};
      case 0x0178:
        return new int[] {0x00FF};
      case 0x0179:
        return new int[] {0x017A};
      case 0x0176:
        return new int[] {0x0177};
      case 0x0170:
        return new int[] {0x0171};
      case 0x0174:
        return new int[] {0x0175};
      case 0x0172:
        return new int[] {0x0173};
      case 0x010A:
        return new int[] {0x010B};
      case 0x1E54:
        return new int[] {0x1E55};
      case 0xFB13:
        return new int[] {0x0574, 0x0576};
      case 0x1E52:
        return new int[] {0x1E53};
      case 0xFB14:
        return new int[] {0x0574, 0x0565};
      case 0x010E:
        return new int[] {0x010F};
      case 0x1E58:
        return new int[] {0x1E59};
      case 0x010C:
        return new int[] {0x010D};
      case 0x1E56:
        return new int[] {0x1E57};
      case 0x0108:
        return new int[] {0x0109};
      case 0xFB15:
        return new int[] {0x0574, 0x056B};
      case 0x1E50:
        return new int[] {0x1E51};
      case 0xFB16:
        return new int[] {0x057E, 0x0576};
      case 0xFB17:
        return new int[] {0x0574, 0x056D};
      case 0x0102:
        return new int[] {0x0103};
      case 0x1E4C:
        return new int[] {0x1E4D};
      case 0x0100:
        return new int[] {0x0101};
      case 0x1E4A:
        return new int[] {0x1E4B};
      case 0x0106:
        return new int[] {0x0107};
      case 0x0345:
        return new int[] {0x03B9};
      case 0x0587:
        return new int[] {0x0565, 0x0582};
      case 0x0104:
        return new int[] {0x0105};
      case 0x1E4E:
        return new int[] {0x1E4F};
      case 0x1E48:
        return new int[] {0x1E49};
      case 0x1E64:
        return new int[] {0x1E65};
      case 0xFB00:
        return new int[] {0x0066, 0x0066};
      case 0x011C:
        return new int[] {0x011D};
      case 0xFB01:
        return new int[] {0x0066, 0x0069};
      case 0x1E62:
        return new int[] {0x1E63};
      case 0xFB02:
        return new int[] {0x0066, 0x006C};
      case 0x011A:
        return new int[] {0x011B};
      case 0xFB03:
        return new int[] {0x0066, 0x0066, 0x0069};
      case 0x1E68:
        return new int[] {0x1E69};
      case 0x1E66:
        return new int[] {0x1E67};
      case 0x011E:
        return new int[] {0x011F};
      case 0x0118:
        return new int[] {0x0119};
      case 0x1E60:
        return new int[] {0x1E61};
      case 0xFB04:
        return new int[] {0x0066, 0x0066, 0x006C};
      case 0xFB05:
        return new int[] {0x0073, 0x0074};
      case 0xFB06:
        return new int[] {0x0073, 0x0074};
      case 0x0112:
        return new int[] {0x0113};
      case 0x1E5C:
        return new int[] {0x1E5D};
      case 0x0110:
        return new int[] {0x0111};
      case 0x1E5A:
        return new int[] {0x1E5B};
      case 0x0116:
        return new int[] {0x0117};
      case 0x0114:
        return new int[] {0x0115};
      case 0x1E5E:
        return new int[] {0x1E5F};
      case 0x012C:
        return new int[] {0x012D};
      case 0x1E76:
        return new int[] {0x1E77};
      case 0x012A:
        return new int[] {0x012B};
      case 0x1E74:
        return new int[] {0x1E75};
      case 0x012E:
        return new int[] {0x012F};
      case 0x1E78:
        return new int[] {0x1E79};
      case 0x1E72:
        return new int[] {0x1E73};
      case 0x1E70:
        return new int[] {0x1E71};
      case 0x0124:
        return new int[] {0x0125};
      case 0x1E6E:
        return new int[] {0x1E6F};
      case 0x0122:
        return new int[] {0x0123};
      case 0x1E6C:
        return new int[] {0x1E6D};
      case 0x0128:
        return new int[] {0x0129};
      case 0x0126:
        return new int[] {0x0127};
      case 0x0120:
        return new int[] {0x0121};
      case 0x1E6A:
        return new int[] {0x1E6B};
      case 0x013D:
        return new int[] {0x013E};
      case 0x1E86:
        return new int[] {0x1E87};
      case 0x013B:
        return new int[] {0x013C};
      case 0x1E84:
        return new int[] {0x1E85};
      case 0x013F:
        return new int[] {0x0140};
      case 0x1E88:
        return new int[] {0x1E89};
      case 0x1E82:
        return new int[] {0x1E83};
      case 0x1E80:
        return new int[] {0x1E81};
      case 0x0134:
        return new int[] {0x0135};
      case 0x1E7E:
        return new int[] {0x1E7F};
      case 0x0132:
        return new int[] {0x0133};
      case 0x1E7C:
        return new int[] {0x1E7D};
      case 0x0139:
        return new int[] {0x013A};
      case 0x0136:
        return new int[] {0x0137};
      case 0x0130:
        return new int[] {0x0069, 0x0307};
      case 0x1E7A:
        return new int[] {0x1E7B};
      case 0x03A0:
        return new int[] {0x03C0};
      case 0x03A1:
        return new int[] {0x03C1};
      case 0x03A4:
        return new int[] {0x03C4};
      case 0x1EAC:
        return new int[] {0x1EAD};
      case 0x03A5:
        return new int[] {0x03C5};
      case 0x1EAA:
        return new int[] {0x1EAB};
      case 0x03A3:
        return new int[] {0x03C3};
      case 0x216B:
        return new int[] {0x217B};
      case 0x1EA8:
        return new int[] {0x1EA9};
      case 0x216A:
        return new int[] {0x217A};
      case 0x10425:
        return new int[] {0x1044D};
      case 0x1EA6:
        return new int[] {0x1EA7};
      case 0x216F:
        return new int[] {0x217F};
      case 0x216E:
        return new int[] {0x217E};
      case 0x216D:
        return new int[] {0x217D};
      case 0x216C:
        return new int[] {0x217C};
      case 0x1EA0:
        return new int[] {0x1EA1};
      case 0x2169:
        return new int[] {0x2179};
      case 0x2168:
        return new int[] {0x2178};
      case 0x10420:
        return new int[] {0x10448};
      case 0x2167:
        return new int[] {0x2177};
      case 0x10422:
        return new int[] {0x1044A};
      case 0x1EA4:
        return new int[] {0x1EA5};
      case 0x10421:
        return new int[] {0x10449};
      case 0x10424:
        return new int[] {0x1044C};
      case 0x1EA2:
        return new int[] {0x1EA3};
      case 0x10423:
        return new int[] {0x1044B};
      case 0x2162:
        return new int[] {0x2172};
      case 0x1041E:
        return new int[] {0x10446};
      case 0x2161:
        return new int[] {0x2171};
      case 0x1041D:
        return new int[] {0x10445};
      case 0x2160:
        return new int[] {0x2170};
      case 0x1041F:
        return new int[] {0x10447};
      case 0x2166:
        return new int[] {0x2176};
      case 0x2165:
        return new int[] {0x2175};
      case 0x2164:
        return new int[] {0x2174};
      case 0x2163:
        return new int[] {0x2173};
      case 0x1EBA:
        return new int[] {0x1EBB};
      case 0x03B0:
        return new int[] {0x03C5, 0x0308, 0x0301};
      case 0x1041A:
        return new int[] {0x10442};
      case 0x1EBE:
        return new int[] {0x1EBF};
      case 0x1041C:
        return new int[] {0x10444};
      case 0x1EBC:
        return new int[] {0x1EBD};
      case 0x1041B:
        return new int[] {0x10443};
      case 0x1EB8:
        return new int[] {0x1EB9};
      case 0x10415:
        return new int[] {0x1043D};
      case 0x10414:
        return new int[] {0x1043C};
      case 0x1EB6:
        return new int[] {0x1EB7};
      case 0x10417:
        return new int[] {0x1043F};
      case 0x10416:
        return new int[] {0x1043E};
      case 0x10419:
        return new int[] {0x10441};
      case 0x10418:
        return new int[] {0x10440};
      case 0x1EB0:
        return new int[] {0x1EB1};
      case 0x03AA:
        return new int[] {0x03CA};
      case 0x1EB4:
        return new int[] {0x1EB5};
      case 0x10411:
        return new int[] {0x10439};
      case 0x10410:
        return new int[] {0x10438};
      case 0x03AB:
        return new int[] {0x03CB};
      case 0x1EB2:
        return new int[] {0x1EB3};
      case 0x10413:
        return new int[] {0x1043B};
      case 0x10412:
        return new int[] {0x1043A};
      case 0x03A8:
        return new int[] {0x03C8};
      case 0x1040D:
        return new int[] {0x10435};
      case 0x03A9:
        return new int[] {0x03C9};
      case 0x1040C:
        return new int[] {0x10434};
      case 0x03A6:
        return new int[] {0x03C6};
      case 0x1EAE:
        return new int[] {0x1EAF};
      case 0x1040F:
        return new int[] {0x10437};
      case 0x03A7:
        return new int[] {0x03C7};
      case 0x1040E:
        return new int[] {0x10436};
      case 0x03C2:
        return new int[] {0x03C3};
      case 0x1ECA:
        return new int[] {0x1ECB};
      case 0x1ECE:
        return new int[] {0x1ECF};
      case 0x1ECC:
        return new int[] {0x1ECD};
      case 0x1EC8:
        return new int[] {0x1EC9};
      case 0x1EC2:
        return new int[] {0x1EC3};
      case 0x1EC0:
        return new int[] {0x1EC1};
      case 0x1EC6:
        return new int[] {0x1EC7};
      case 0x1EC4:
        return new int[] {0x1EC5};
      case 0x1EDC:
        return new int[] {0x1EDD};
      case 0x03D1:
        return new int[] {0x03B8};
      case 0x1EDA:
        return new int[] {0x1EDB};
      case 0x03D8:
        return new int[] {0x03D9};
      case 0x03D5:
        return new int[] {0x03C6};
      case 0x03D6:
        return new int[] {0x03C0};
      case 0x1EDE:
        return new int[] {0x1EDF};
      case 0x1ED8:
        return new int[] {0x1ED9};
      case 0x03D0:
        return new int[] {0x03B2};
      case 0x1ED2:
        return new int[] {0x1ED3};
      case 0x1ED0:
        return new int[] {0x1ED1};
      case 0x1ED6:
        return new int[] {0x1ED7};
      case 0x1ED4:
        return new int[] {0x1ED5};
      case 0x018A:
        return new int[] {0x0257};
      case 0x018B:
        return new int[] {0x018C};
      case 0x018E:
        return new int[] {0x01DD};
      case 0x212B:
        return new int[] {0x00E5};
      case 0x018F:
        return new int[] {0x0259};
      case 0x212A:
        return new int[] {0x006B};
      case 0x0189:
        return new int[] {0x0256};
      case 0x2126:
        return new int[] {0x03C9};
      case 0x0187:
        return new int[] {0x0188};
      case 0x0181:
        return new int[] {0x0253};
      case 0x0182:
        return new int[] {0x0183};
      case 0x0186:
        return new int[] {0x0254};
      case 0x0184:
        return new int[] {0x0185};
      case 0x019C:
        return new int[] {0x026F};
      case 0x019F:
        return new int[] {0x0275};
      case 0x019D:
        return new int[] {0x0272};
      case 0x0198:
        return new int[] {0x0199};
      case 0x0193:
        return new int[] {0x0260};
      case 0x0190:
        return new int[] {0x025B};
      case 0x0191:
        return new int[] {0x0192};
      case 0x0196:
        return new int[] {0x0269};
      case 0x0197:
        return new int[] {0x0268};
      case 0x0194:
        return new int[] {0x0263};
      case 0x1040B:
        return new int[] {0x10433};
      case 0x1040A:
        return new int[] {0x10432};
      case 0x10404:
        return new int[] {0x1042C};
      case 0x10403:
        return new int[] {0x1042B};
      case 0x10406:
        return new int[] {0x1042E};
      case 0x10405:
        return new int[] {0x1042D};
      case 0x10408:
        return new int[] {0x10430};
      case 0x10407:
        return new int[] {0x1042F};
      case 0x10409:
        return new int[] {0x10431};
      case 0x10400:
        return new int[] {0x10428};
      case 0x10402:
        return new int[] {0x1042A};
      case 0x10401:
        return new int[] {0x10429};
      case 0x01E6:
        return new int[] {0x01E7};
      case 0x01E4:
        return new int[] {0x01E5};
      case 0x01E8:
        return new int[] {0x01E9};
      case 0x01E2:
        return new int[] {0x01E3};
      case 0x01E0:
        return new int[] {0x01E1};
      case 0x01DE:
        return new int[] {0x01DF};
      case 0x01DB:
        return new int[] {0x01DC};
      case 0x01F7:
        return new int[] {0x01BF};
      case 0x01F8:
        return new int[] {0x01F9};
      case 0x01F6:
        return new int[] {0x0195};
      case 0x01F0:
        return new int[] {0x006A, 0x030C};
      case 0x01F4:
        return new int[] {0x01F5};
      case 0x01F1:
        return new int[] {0x01F3};
      case 0x01F2:
        return new int[] {0x01F3};
      case 0x01EE:
        return new int[] {0x01EF};
      case 0x01EC:
        return new int[] {0x01ED};
      case 0x01EA:
        return new int[] {0x01EB};
      case 0x01FE:
        return new int[] {0x01FF};
      case 0x01FC:
        return new int[] {0x01FD};
      case 0x01FA:
        return new int[] {0x01FB};
      case 0x01A2:
        return new int[] {0x01A3};
      case 0x03E4:
        return new int[] {0x03E5};
      case 0x1EEC:
        return new int[] {0x1EED};
      case 0x01A0:
        return new int[] {0x01A1};
      case 0x03E2:
        return new int[] {0x03E3};
      case 0x1EEA:
        return new int[] {0x1EEB};
      case 0x01A6:
        return new int[] {0x0280};
      case 0x03E8:
        return new int[] {0x03E9};
      case 0x01A7:
        return new int[] {0x01A8};
      case 0x01A4:
        return new int[] {0x01A5};
      case 0x03E6:
        return new int[] {0x03E7};
      case 0x1EEE:
        return new int[] {0x1EEF};
      case 0x03E0:
        return new int[] {0x03E1};
      case 0x03DC:
        return new int[] {0x03DD};
      case 0x1EE4:
        return new int[] {0x1EE5};
      case 0x03DA:
        return new int[] {0x03DB};
      case 0x1EE2:
        return new int[] {0x1EE3};
      case 0x1EE8:
        return new int[] {0x1EE9};
      case 0x03DE:
        return new int[] {0x03DF};
      case 0x1EE6:
        return new int[] {0x1EE7};
      case 0x1EE0:
        return new int[] {0x1EE1};
      case 0x01B3:
        return new int[] {0x01B4};
      case 0x03F5:
        return new int[] {0x03B5};
      case 0x01B1:
        return new int[] {0x028A};
      case 0x01B2:
        return new int[] {0x028B};
      case 0x03F4:
        return new int[] {0x03B8};
      case 0x01B7:
        return new int[] {0x0292};
      case 0x01B8:
        return new int[] {0x01B9};
      case 0x01B5:
        return new int[] {0x01B6};
      case 0x03F1:
        return new int[] {0x03C1};
      case 0x03F2:
        return new int[] {0x03C3};
      case 0x03F0:
        return new int[] {0x03BA};
      case 0x1EF4:
        return new int[] {0x1EF5};
      case 0x01AC:
        return new int[] {0x01AD};
      case 0x03EE:
        return new int[] {0x03EF};
      case 0x1EF2:
        return new int[] {0x1EF3};
      case 0x03EC:
        return new int[] {0x03ED};
      case 0x01AF:
        return new int[] {0x01B0};
      case 0x1EF8:
        return new int[] {0x1EF9};
      case 0x1EF6:
        return new int[] {0x1EF7};
      case 0x01AE:
        return new int[] {0x0288};
      case 0x01A9:
        return new int[] {0x0283};
      case 0x1EF0:
        return new int[] {0x1EF1};
      case 0x03EA:
        return new int[] {0x03EB};
      case 0x01C4:
        return new int[] {0x01C6};
      case 0x01C5:
        return new int[] {0x01C6};
      case 0x01C8:
        return new int[] {0x01C9};
      case 0x01C7:
        return new int[] {0x01C9};
      case 0x01BC:
        return new int[] {0x01BD};
      case 0x01D5:
        return new int[] {0x01D6};
      case 0x01D3:
        return new int[] {0x01D4};
      case 0x01D9:
        return new int[] {0x01DA};
      case 0x01D7:
        return new int[] {0x01D8};
      case 0x01D1:
        return new int[] {0x01D2};
      case 0x01CD:
        return new int[] {0x01CE};
      case 0x01CB:
        return new int[] {0x01CC};
      case 0x01CF:
        return new int[] {0x01D0};
      case 0x01CA:
        return new int[] {0x01CC};
      case 0x042A:
        return new int[] {0x044A};
      case 0x042D:
        return new int[] {0x044D};
      case 0x042E:
        return new int[] {0x044E};
      case 0x042B:
        return new int[] {0x044B};
      case 0x042C:
        return new int[] {0x044C};
      case 0x0428:
        return new int[] {0x0448};
      case 0x0429:
        return new int[] {0x0449};
      case 0x0426:
        return new int[] {0x0446};
      case 0x1F2E:
        return new int[] {0x1F26};
      case 0x0427:
        return new int[] {0x0447};
      case 0x1F2F:
        return new int[] {0x1F27};
      case 0x0420:
        return new int[] {0x0440};
      case 0x0421:
        return new int[] {0x0441};
      case 0x0424:
        return new int[] {0x0444};
      case 0x1F2C:
        return new int[] {0x1F24};
      case 0x0425:
        return new int[] {0x0445};
      case 0x1F2D:
        return new int[] {0x1F25};
      case 0x0422:
        return new int[] {0x0442};
      case 0x1F2A:
        return new int[] {0x1F22};
      case 0x0423:
        return new int[] {0x0443};
      case 0x1F2B:
        return new int[] {0x1F23};
      case 0x1F28:
        return new int[] {0x1F20};
      case 0x041E:
        return new int[] {0x043E};
      case 0x041F:
        return new int[] {0x043F};
      case 0x1F29:
        return new int[] {0x1F21};
      case 0x1F3F:
        return new int[] {0x1F37};
      case 0x1F3A:
        return new int[] {0x1F32};
      case 0x1F3D:
        return new int[] {0x1F35};
      case 0x1F3E:
        return new int[] {0x1F36};
      case 0x1F3B:
        return new int[] {0x1F33};
      case 0x1F3C:
        return new int[] {0x1F34};
      case 0x1F38:
        return new int[] {0x1F30};
      case 0x1F39:
        return new int[] {0x1F31};
      case 0x042F:
        return new int[] {0x044F};
      case 0x1F52:
        return new int[] {0x03C5, 0x0313, 0x0300};
      case 0x020A:
        return new int[] {0x020B};
      case 0x1F50:
        return new int[] {0x03C5, 0x0313};
      case 0x1F56:
        return new int[] {0x03C5, 0x0313, 0x0342};
      case 0x020E:
        return new int[] {0x020F};
      case 0x1F54:
        return new int[] {0x03C5, 0x0313, 0x0301};
      case 0x020C:
        return new int[] {0x020D};
      case 0x0208:
        return new int[] {0x0209};
      case 0x0206:
        return new int[] {0x0207};
      case 0x0200:
        return new int[] {0x0201};
      case 0x1F4A:
        return new int[] {0x1F42};
      case 0x1F4B:
        return new int[] {0x1F43};
      case 0x0204:
        return new int[] {0x0205};
      case 0x0202:
        return new int[] {0x0203};
      case 0x1F4C:
        return new int[] {0x1F44};
      case 0x1F4D:
        return new int[] {0x1F45};
      case 0x1F49:
        return new int[] {0x1F41};
      case 0x1F48:
        return new int[] {0x1F40};
      case 0x021A:
        return new int[] {0x021B};
      case 0x021E:
        return new int[] {0x021F};
      case 0x1F68:
        return new int[] {0x1F60};
      case 0x021C:
        return new int[] {0x021D};
      case 0x0218:
        return new int[] {0x0219};
      case 0x1F5B:
        return new int[] {0x1F53};
      case 0x0212:
        return new int[] {0x0213};
      case 0x0210:
        return new int[] {0x0211};
      case 0x1F5F:
        return new int[] {0x1F57};
      case 0x0216:
        return new int[] {0x0217};
      case 0x1F5D:
        return new int[] {0x1F55};
      case 0x0214:
        return new int[] {0x0215};
      case 0x1F59:
        return new int[] {0x1F51};
      case 0x040B:
        return new int[] {0x045B};
      case 0x040C:
        return new int[] {0x045C};
      case 0x040A:
        return new int[] {0x045A};
      case 0x0406:
        return new int[] {0x0456};
      case 0x1F0E:
        return new int[] {0x1F06};
      case 0x0407:
        return new int[] {0x0457};
      case 0x1F0F:
        return new int[] {0x1F07};
      case 0x0404:
        return new int[] {0x0454};
      case 0x1F0C:
        return new int[] {0x1F04};
      case 0x0405:
        return new int[] {0x0455};
      case 0x1F0D:
        return new int[] {0x1F05};
      case 0x0408:
        return new int[] {0x0458};
      case 0x0409:
        return new int[] {0x0459};
      case 0x0402:
        return new int[] {0x0452};
      case 0x1F0A:
        return new int[] {0x1F02};
      case 0x0403:
        return new int[] {0x0453};
      case 0x1F0B:
        return new int[] {0x1F03};
      case 0x0400:
        return new int[] {0x0450};
      case 0x0401:
        return new int[] {0x0451};
      case 0x1F09:
        return new int[] {0x1F01};
      case 0x1F08:
        return new int[] {0x1F00};
      case 0x041C:
        return new int[] {0x043C};
      case 0x041D:
        return new int[] {0x043D};
      case 0x041A:
        return new int[] {0x043A};
      case 0x041B:
        return new int[] {0x043B};
      case 0x0417:
        return new int[] {0x0437};
      case 0x0418:
        return new int[] {0x0438};
      case 0x0415:
        return new int[] {0x0435};
      case 0x1F1D:
        return new int[] {0x1F15};
      case 0x0416:
        return new int[] {0x0436};
      case 0x0419:
        return new int[] {0x0439};
      case 0x0410:
        return new int[] {0x0430};
      case 0x0413:
        return new int[] {0x0433};
      case 0x1F1B:
        return new int[] {0x1F13};
      case 0x0414:
        return new int[] {0x0434};
      case 0x1F1C:
        return new int[] {0x1F14};
      case 0x0411:
        return new int[] {0x0431};
      case 0x0412:
        return new int[] {0x0432};
      case 0x1F1A:
        return new int[] {0x1F12};
      case 0x040F:
        return new int[] {0x045F};
      case 0x040D:
        return new int[] {0x045D};
      case 0x040E:
        return new int[] {0x045E};
      case 0x1F18:
        return new int[] {0x1F10};
      case 0x1F19:
        return new int[] {0x1F11};
      case 0x004F:
        return new int[] {0x006F};
      case 0x004D:
        return new int[] {0x006D};
      case 0x004E:
        return new int[] {0x006E};
      case 0x004B:
        return new int[] {0x006B};
      case 0x004C:
        return new int[] {0x006C};
      case 0x004A:
        return new int[] {0x006A};
      case 0x0046:
        return new int[] {0x0066};
      case 0x0047:
        return new int[] {0x0067};
      case 0x0044:
        return new int[] {0x0064};
      case 0x0045:
        return new int[] {0x0065};
      case 0x0048:
        return new int[] {0x0068};
      case 0x0049:
        return new int[] {0x0069};
      case 0x0042:
        return new int[] {0x0062};
      case 0x0043:
        return new int[] {0x0063};
      case 0x0041:
        return new int[] {0x0061};
      case 0x005A:
        return new int[] {0x007A};
      case 0x0057:
        return new int[] {0x0077};
      case 0x0058:
        return new int[] {0x0078};
      case 0x0055:
        return new int[] {0x0075};
      case 0x0056:
        return new int[] {0x0076};
      case 0x0059:
        return new int[] {0x0079};
      case 0x0050:
        return new int[] {0x0070};
      case 0x0053:
        return new int[] {0x0073};
      case 0x0054:
        return new int[] {0x0074};
      case 0x0051:
        return new int[] {0x0071};
      case 0x0052:
        return new int[] {0x0072};
      case 0x022C:
        return new int[] {0x022D};
      case 0x046E:
        return new int[] {0x046F};
      case 0x022A:
        return new int[] {0x022B};
      case 0x046C:
        return new int[] {0x046D};
      case 0x022E:
        return new int[] {0x022F};
      case 0x0228:
        return new int[] {0x0229};
      case 0x046A:
        return new int[] {0x046B};
      case 0x0222:
        return new int[] {0x0223};
      case 0x0464:
        return new int[] {0x0465};
      case 0x1F6C:
        return new int[] {0x1F64};
      case 0x1F6D:
        return new int[] {0x1F65};
      case 0x0220:
        return new int[] {0x019E};
      case 0x0462:
        return new int[] {0x0463};
      case 0x1F6A:
        return new int[] {0x1F62};
      case 0x1F6B:
        return new int[] {0x1F63};
      case 0x0226:
        return new int[] {0x0227};
      case 0x0468:
        return new int[] {0x0469};
      case 0x0224:
        return new int[] {0x0225};
      case 0x0466:
        return new int[] {0x0467};
      case 0x1F6E:
        return new int[] {0x1F66};
      case 0x1F6F:
        return new int[] {0x1F67};
      case 0x1F69:
        return new int[] {0x1F61};
      case 0x0460:
        return new int[] {0x0461};
      case 0x047E:
        return new int[] {0x047F};
      case 0x1F85:
        return new int[] {0x1F05, 0x03B9};
      case 0x1F86:
        return new int[] {0x1F06, 0x03B9};
      case 0x047C:
        return new int[] {0x047D};
      case 0x1F83:
        return new int[] {0x1F03, 0x03B9};
      case 0x1F84:
        return new int[] {0x1F04, 0x03B9};
      case 0x1F89:
        return new int[] {0x1F01, 0x03B9};
      case 0x1F87:
        return new int[] {0x1F07, 0x03B9};
      case 0x1F88:
        return new int[] {0x1F00, 0x03B9};
      case 0x047A:
        return new int[] {0x047B};
      case 0x1F81:
        return new int[] {0x1F01, 0x03B9};
      case 0x1F82:
        return new int[] {0x1F02, 0x03B9};
      case 0x1F80:
        return new int[] {0x1F00, 0x03B9};
      case 0x0476:
        return new int[] {0x0477};
      case 0x0232:
        return new int[] {0x0233};
      case 0x0474:
        return new int[] {0x0475};
      case 0x0478:
        return new int[] {0x0479};
      case 0x0230:
        return new int[] {0x0231};
      case 0x0472:
        return new int[] {0x0473};
      case 0x0470:
        return new int[] {0x0471};
      case 0x1F96:
        return new int[] {0x1F26, 0x03B9};
      case 0x1F97:
        return new int[] {0x1F27, 0x03B9};
      case 0x1F94:
        return new int[] {0x1F24, 0x03B9};
      case 0x048E:
        return new int[] {0x048F};
      case 0x1F95:
        return new int[] {0x1F25, 0x03B9};
      case 0x1F98:
        return new int[] {0x1F20, 0x03B9};
      case 0x1F99:
        return new int[] {0x1F21, 0x03B9};
      case 0x1F92:
        return new int[] {0x1F22, 0x03B9};
      case 0x048C:
        return new int[] {0x048D};
      case 0x1F93:
        return new int[] {0x1F23, 0x03B9};
      case 0x1F90:
        return new int[] {0x1F20, 0x03B9};
      case 0x048A:
        return new int[] {0x048B};
      case 0x1F91:
        return new int[] {0x1F21, 0x03B9};
      case 0x1F8E:
        return new int[] {0x1F06, 0x03B9};
      case 0x1F8F:
        return new int[] {0x1F07, 0x03B9};
      case 0x1F8C:
        return new int[] {0x1F04, 0x03B9};
      case 0x1F8D:
        return new int[] {0x1F05, 0x03B9};
      case 0x1F8A:
        return new int[] {0x1F02, 0x03B9};
      case 0x1F8B:
        return new int[] {0x1F03, 0x03B9};
      case 0x0480:
        return new int[] {0x0481};
      case 0x049E:
        return new int[] {0x049F};
      case 0x049C:
        return new int[] {0x049D};
      case 0x049A:
        return new int[] {0x049B};
      case 0x1F9F:
        return new int[] {0x1F27, 0x03B9};
      case 0x0498:
        return new int[] {0x0499};
      case 0x1F9D:
        return new int[] {0x1F25, 0x03B9};
      case 0x0496:
        return new int[] {0x0497};
      case 0x1F9E:
        return new int[] {0x1F26, 0x03B9};
      case 0x0490:
        return new int[] {0x0491};
      case 0x1F9B:
        return new int[] {0x1F23, 0x03B9};
      case 0x0494:
        return new int[] {0x0495};
      case 0x1F9C:
        return new int[] {0x1F24, 0x03B9};
      case 0x0492:
        return new int[] {0x0493};
      case 0x1F9A:
        return new int[] {0x1F22, 0x03B9};
      case 0x04C1:
        return new int[] {0x04C2};
      case 0x1FCA:
        return new int[] {0x1F74};
      case 0x04C5:
        return new int[] {0x04C6};
      case 0x04C3:
        return new int[] {0x04C4};
      case 0x1FCB:
        return new int[] {0x1F75};
      case 0x1FCC:
        return new int[] {0x03B7, 0x03B9};
      case 0x1FC8:
        return new int[] {0x1F72};
      case 0x1FC9:
        return new int[] {0x1F73};
      case 0x1FC6:
        return new int[] {0x03B7, 0x0342};
      case 0x1FC7:
        return new int[] {0x03B7, 0x0342, 0x03B9};
      case 0x04BA:
        return new int[] {0x04BB};
      case 0x1FC4:
        return new int[] {0x03AE, 0x03B9};
      case 0x04BE:
        return new int[] {0x04BF};
      case 0x1FC2:
        return new int[] {0x1F74, 0x03B9};
      case 0x04BC:
        return new int[] {0x04BD};
      case 0x1FC3:
        return new int[] {0x03B7, 0x03B9};
      case 0x04B8:
        return new int[] {0x04B9};
      case 0x04B6:
        return new int[] {0x04B7};
      case 0x1FBE:
        return new int[] {0x03B9};
      case 0x04D2:
        return new int[] {0x04D3};
      case 0x1FDA:
        return new int[] {0x1F76};
      case 0x1FDB:
        return new int[] {0x1F77};
      case 0x04D0:
        return new int[] {0x04D1};
      case 0x04D6:
        return new int[] {0x04D7};
      case 0x04D4:
        return new int[] {0x04D5};
      case 0x1FD9:
        return new int[] {0x1FD1};
      case 0x1FD7:
        return new int[] {0x03B9, 0x0308, 0x0342};
      case 0x1FD8:
        return new int[] {0x1FD0};
      case 0x04CB:
        return new int[] {0x04CC};
      case 0x1FD2:
        return new int[] {0x03B9, 0x0308, 0x0300};
      case 0x1FD6:
        return new int[] {0x03B9, 0x0342};
      case 0x1FD3:
        return new int[] {0x03B9, 0x0308, 0x0301};
      case 0x04CD:
        return new int[] {0x04CE};
      case 0x04C9:
        return new int[] {0x04CA};
      case 0x04C7:
        return new int[] {0x04C8};
      case 0x1FEB:
        return new int[] {0x1F7B};
      case 0x04E4:
        return new int[] {0x04E5};
      case 0x1FEC:
        return new int[] {0x1FE5};
      case 0x04E2:
        return new int[] {0x04E3};
      case 0x1FEA:
        return new int[] {0x1F7A};
      case 0x04E8:
        return new int[] {0x04E9};
      case 0x04E6:
        return new int[] {0x04E7};
      case 0x1FE8:
        return new int[] {0x1FE0};
      case 0x1FE9:
        return new int[] {0x1FE1};
      case 0x04E0:
        return new int[] {0x04E1};
      case 0x1FE2:
        return new int[] {0x03C5, 0x0308, 0x0300};
      case 0x04DC:
        return new int[] {0x04DD};
      case 0x1FE3:
        return new int[] {0x03C5, 0x0308, 0x0301};
      case 0x04DA:
        return new int[] {0x04DB};
      case 0x1FE6:
        return new int[] {0x03C5, 0x0342};
      case 0x1FE7:
        return new int[] {0x03C5, 0x0308, 0x0342};
      case 0x1FE4:
        return new int[] {0x03C1, 0x0313};
      case 0x04DE:
        return new int[] {0x04DF};
      case 0x04D8:
        return new int[] {0x04D9};
      case 0x04F4:
        return new int[] {0x04F5};
      case 0x1FFC:
        return new int[] {0x03C9, 0x03B9};
      case 0x04F2:
        return new int[] {0x04F3};
      case 0x1FFA:
        return new int[] {0x1F7C};
      case 0x1FFB:
        return new int[] {0x1F7D};
      case 0x04F8:
        return new int[] {0x04F9};
      case 0x1FF9:
        return new int[] {0x1F79};
      case 0x04F0:
        return new int[] {0x04F1};
      case 0x04EC:
        return new int[] {0x04ED};
      case 0x1FF3:
        return new int[] {0x03C9, 0x03B9};
      case 0x1FF4:
        return new int[] {0x03CE, 0x03B9};
      case 0x04EA:
        return new int[] {0x04EB};
      case 0x1FF2:
        return new int[] {0x1F7C, 0x03B9};
      case 0x1FF7:
        return new int[] {0x03C9, 0x0342, 0x03B9};
      case 0x1FF8:
        return new int[] {0x1F78};
      case 0x04EE:
        return new int[] {0x04EF};
      case 0x1FF6:
        return new int[] {0x03C9, 0x0342};
      case 0x04A0:
        return new int[] {0x04A1};
      case 0x1FAB:
        return new int[] {0x1F63, 0x03B9};
      case 0x04A4:
        return new int[] {0x04A5};
      case 0x1FAC:
        return new int[] {0x1F64, 0x03B9};
      case 0x04A2:
        return new int[] {0x04A3};
      case 0x1FAA:
        return new int[] {0x1F62, 0x03B9};
      case 0x1FA6:
        return new int[] {0x1F66, 0x03B9};
      case 0x1FA7:
        return new int[] {0x1F67, 0x03B9};
      case 0x1FA4:
        return new int[] {0x1F64, 0x03B9};
      case 0x1FA5:
        return new int[] {0x1F65, 0x03B9};
      case 0x1FA8:
        return new int[] {0x1F60, 0x03B9};
      case 0x1FA9:
        return new int[] {0x1F61, 0x03B9};
      case 0x1FA2:
        return new int[] {0x1F62, 0x03B9};
      case 0x1FA3:
        return new int[] {0x1F63, 0x03B9};
      case 0x1FA0:
        return new int[] {0x1F60, 0x03B9};
      case 0x1FA1:
        return new int[] {0x1F61, 0x03B9};
      case 0x04B0:
        return new int[] {0x04B1};
      case 0x04B4:
        return new int[] {0x04B5};
      case 0x1FBC:
        return new int[] {0x03B1, 0x03B9};
      case 0x04B2:
        return new int[] {0x04B3};
      case 0x1FBA:
        return new int[] {0x1F70};
      case 0x1FBB:
        return new int[] {0x1F71};
      case 0x1FB7:
        return new int[] {0x03B1, 0x0342, 0x03B9};
      case 0x1FB8:
        return new int[] {0x1FB0};
      case 0x04AE:
        return new int[] {0x04AF};
      case 0x1FB6:
        return new int[] {0x03B1, 0x0342};
      case 0x1FB9:
        return new int[] {0x1FB1};
      case 0x04AC:
        return new int[] {0x04AD};
      case 0x1FB3:
        return new int[] {0x03B1, 0x03B9};
      case 0x1FB4:
        return new int[] {0x03AC, 0x03B9};
      case 0x04AA:
        return new int[] {0x04AB};
      case 0x1FB2:
        return new int[] {0x1F70, 0x03B9};
      case 0x1FAF:
        return new int[] {0x1F67, 0x03B9};
      case 0x04A8:
        return new int[] {0x04A9};
      case 0x1FAD:
        return new int[] {0x1F65, 0x03B9};
      case 0x04A6:
        return new int[] {0x04A7};
      case 0x1FAE:
        return new int[] {0x1F66, 0x03B9};
      default:
        return new int[] {codePoint};
    }
  }

  /**
   * ASCII space characters.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "ASCII space characters".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.1.1">RFC 3454, Appendix C.1.1</a>
   */
  public static boolean prohibitionAsciiSpace(int codePoint) {
    return codePoint == 0x0020
        ;
  }

  /**
   * Non-ASCII space characters.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "Non-ASCII space characters".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.1.2">RFC 3454, Appendix C.1.2</a>
   */
  public static boolean prohibitionNonAsciiSpace(int codePoint) {
    return codePoint == 0x00A0
        || codePoint == 0x1680
        || codePoint == 0x2000
        || codePoint == 0x2001
        || codePoint == 0x2002
        || codePoint == 0x2003
        || codePoint == 0x2004
        || codePoint == 0x2005
        || codePoint == 0x2006
        || codePoint == 0x2007
        || codePoint == 0x2008
        || codePoint == 0x2009
        || codePoint == 0x200A
        || codePoint == 0x200B
        || codePoint == 0x202F
        || codePoint == 0x205F
        || codePoint == 0x3000
        ;
  }

  /**
   * ASCII control characters.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "ASCII control characters".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.2.1">RFC 3454, Appendix C.2.1</a>
   */
  public static boolean prohibitionAsciiControl(int codePoint) {
    return (codePoint >= 0x0000 && codePoint <= 0x001F)
        || codePoint == 0x007F
        ;
  }

  /**
   * Non-ASCII control characters.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "Non-ASCII control characters".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.2.2">RFC 3454, Appendix C.2.2</a>
   */
  public static boolean prohibitionNonAsciiControl(int codePoint) {
    return (codePoint >= 0x0080 && codePoint <= 0x009F)
        || codePoint == 0x06DD
        || codePoint == 0x070F
        || codePoint == 0x180E
        || codePoint == 0x200C
        || codePoint == 0x200D
        || codePoint == 0x2028
        || codePoint == 0x2029
        || codePoint == 0x2060
        || codePoint == 0x2061
        || codePoint == 0x2062
        || codePoint == 0x2063
        || (codePoint >= 0x206A && codePoint <= 0x206F)
        || codePoint == 0xFEFF
        || (codePoint >= 0xFFF9 && codePoint <= 0xFFFC)
        || (codePoint >= 0x1D173 && codePoint <= 0x1D17A)
        ;
  }

  /**
   * Private use.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "Private use".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.3">RFC 3454, Appendix C.3</a>
   */
  public static boolean prohibitionPrivateUse(int codePoint) {
    return (codePoint >= 0xE000 && codePoint <= 0xF8FF)
        || (codePoint >= 0xF0000 && codePoint <= 0xFFFFD)
        || (codePoint >= 0x100000 && codePoint <= 0x10FFFD)
        ;
  }

  /**
   * Non-character code points.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "Non-character code points".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.4">RFC 3454, Appendix C.4</a>
   */
  public static boolean prohibitionNonCharacterCodePoints(int codePoint) {
    return (codePoint >= 0xFDD0 && codePoint <= 0xFDEF)
        || (codePoint >= 0xFFFE && codePoint <= 0xFFFF)
        || (codePoint >= 0x1FFFE && codePoint <= 0x1FFFF)
        || (codePoint >= 0x2FFFE && codePoint <= 0x2FFFF)
        || (codePoint >= 0x3FFFE && codePoint <= 0x3FFFF)
        || (codePoint >= 0x4FFFE && codePoint <= 0x4FFFF)
        || (codePoint >= 0x5FFFE && codePoint <= 0x5FFFF)
        || (codePoint >= 0x6FFFE && codePoint <= 0x6FFFF)
        || (codePoint >= 0x7FFFE && codePoint <= 0x7FFFF)
        || (codePoint >= 0x8FFFE && codePoint <= 0x8FFFF)
        || (codePoint >= 0x9FFFE && codePoint <= 0x9FFFF)
        || (codePoint >= 0xAFFFE && codePoint <= 0xAFFFF)
        || (codePoint >= 0xBFFFE && codePoint <= 0xBFFFF)
        || (codePoint >= 0xCFFFE && codePoint <= 0xCFFFF)
        || (codePoint >= 0xDFFFE && codePoint <= 0xDFFFF)
        || (codePoint >= 0xEFFFE && codePoint <= 0xEFFFF)
        || (codePoint >= 0xFFFFE && codePoint <= 0xFFFFF)
        || (codePoint >= 0x10FFFE && codePoint <= 0x10FFFF)
        ;
  }

  /**
   * Surrogate codes.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "Surrogate codes".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.5">RFC 3454, Appendix C.5</a>
   */
  public static boolean prohibitionSurrogateCodes(int codePoint) {
    return (codePoint >= 0xD800 && codePoint <= 0xDFFF)
        ;
  }

  /**
   * Inappropriate for plain text.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is
   *         "Inappropriate for plain text".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.6">RFC 3454, Appendix C.6</a>
   */
  public static boolean prohibitionInappropriatePlainText(int codePoint) {
    return codePoint == 0xFFF9
        || codePoint == 0xFFFA
        || codePoint == 0xFFFB
        || codePoint == 0xFFFC
        || codePoint == 0xFFFD
        ;
  }

  /**
   * Inappropriate for canonical representation.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is
   *         "Inappropriate for canonical representation".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.7">RFC 3454, Appendix C.7</a>
   */
  public static boolean prohibitionInappropriateCanonicalRepresentation(int codePoint) {
    return (codePoint >= 0x2FF0 && codePoint <= 0x2FFB)
        ;
  }

  /**
   * Change display properties or are deprecated.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is
   *         "Change display properties or are deprecated".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.8">RFC 3454, Appendix C.8</a>
   */
  public static boolean prohibitionChangeDisplayProperties(int codePoint) {
    return codePoint == 0x0340
        || codePoint == 0x0341
        || codePoint == 0x200E
        || codePoint == 0x200F
        || codePoint == 0x202A
        || codePoint == 0x202B
        || codePoint == 0x202C
        || codePoint == 0x202D
        || codePoint == 0x202E
        || codePoint == 0x206A
        || codePoint == 0x206B
        || codePoint == 0x206C
        || codePoint == 0x206D
        || codePoint == 0x206E
        || codePoint == 0x206F
        ;
  }

  /**
   * Tagging characters.
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is "Tagging characters".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-C.9">RFC 3454, Appendix C.9</a>
   */
  public static boolean prohibitionTaggingCharacters(int codePoint) {
    return codePoint == 0xE0001
        || (codePoint >= 0xE0020 && codePoint <= 0xE007F)
        ;
  }

  /**
   * Characters with bidirectional property "R" or "AL".
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is
   *         "Characters with bidirectional property R or AL".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-D.1">RFC 3454, Appendix D.1</a>
   */
  public static boolean bidirectionalPropertyRorAL(int codePoint) {
    return codePoint == 0x05BE
        || codePoint == 0x05C0
        || codePoint == 0x05C3
        || (codePoint >= 0x05D0 && codePoint <= 0x05EA)
        || (codePoint >= 0x05F0 && codePoint <= 0x05F4)
        || codePoint == 0x061B
        || codePoint == 0x061F
        || (codePoint >= 0x0621 && codePoint <= 0x063A)
        || (codePoint >= 0x0640 && codePoint <= 0x064A)
        || (codePoint >= 0x066D && codePoint <= 0x066F)
        || (codePoint >= 0x0671 && codePoint <= 0x06D5)
        || codePoint == 0x06DD
        || (codePoint >= 0x06E5 && codePoint <= 0x06E6)
        || (codePoint >= 0x06FA && codePoint <= 0x06FE)
        || (codePoint >= 0x0700 && codePoint <= 0x070D)
        || codePoint == 0x0710
        || (codePoint >= 0x0712 && codePoint <= 0x072C)
        || (codePoint >= 0x0780 && codePoint <= 0x07A5)
        || codePoint == 0x07B1
        || codePoint == 0x200F
        || codePoint == 0xFB1D
        || (codePoint >= 0xFB1F && codePoint <= 0xFB28)
        || (codePoint >= 0xFB2A && codePoint <= 0xFB36)
        || (codePoint >= 0xFB38 && codePoint <= 0xFB3C)
        || codePoint == 0xFB3E
        || (codePoint >= 0xFB40 && codePoint <= 0xFB41)
        || (codePoint >= 0xFB43 && codePoint <= 0xFB44)
        || (codePoint >= 0xFB46 && codePoint <= 0xFBB1)
        || (codePoint >= 0xFBD3 && codePoint <= 0xFD3D)
        || (codePoint >= 0xFD50 && codePoint <= 0xFD8F)
        || (codePoint >= 0xFD92 && codePoint <= 0xFDC7)
        || (codePoint >= 0xFDF0 && codePoint <= 0xFDFC)
        || (codePoint >= 0xFE70 && codePoint <= 0xFE74)
        || (codePoint >= 0xFE76 && codePoint <= 0xFEFC)
        ;
  }

  /**
   * Characters with bidirectional property "L".
   *
   * @param codePoint the character (Unicode code point) to be tested.
   * @return {@code true} if the given {@code codePoint} is
   *         "Characters with bidirectional property L".
   * @see <a href="https://tools.ietf.org/html/rfc3454#appendix-D.2">RFC 3454, Appendix D.2</a>
   */
  public static boolean bidirectionalPropertyL(int codePoint) {
    return (codePoint >= 0x0041 && codePoint <= 0x005A)
        || (codePoint >= 0x0061 && codePoint <= 0x007A)
        || codePoint == 0x00AA
        || codePoint == 0x00B5
        || codePoint == 0x00BA
        || (codePoint >= 0x00C0 && codePoint <= 0x00D6)
        || (codePoint >= 0x00D8 && codePoint <= 0x00F6)
        || (codePoint >= 0x00F8 && codePoint <= 0x0220)
        || (codePoint >= 0x0222 && codePoint <= 0x0233)
        || (codePoint >= 0x0250 && codePoint <= 0x02AD)
        || (codePoint >= 0x02B0 && codePoint <= 0x02B8)
        || (codePoint >= 0x02BB && codePoint <= 0x02C1)
        || (codePoint >= 0x02D0 && codePoint <= 0x02D1)
        || (codePoint >= 0x02E0 && codePoint <= 0x02E4)
        || codePoint == 0x02EE
        || codePoint == 0x037A
        || codePoint == 0x0386
        || (codePoint >= 0x0388 && codePoint <= 0x038A)
        || codePoint == 0x038C
        || (codePoint >= 0x038E && codePoint <= 0x03A1)
        || (codePoint >= 0x03A3 && codePoint <= 0x03CE)
        || (codePoint >= 0x03D0 && codePoint <= 0x03F5)
        || (codePoint >= 0x0400 && codePoint <= 0x0482)
        || (codePoint >= 0x048A && codePoint <= 0x04CE)
        || (codePoint >= 0x04D0 && codePoint <= 0x04F5)
        || (codePoint >= 0x04F8 && codePoint <= 0x04F9)
        || (codePoint >= 0x0500 && codePoint <= 0x050F)
        || (codePoint >= 0x0531 && codePoint <= 0x0556)
        || (codePoint >= 0x0559 && codePoint <= 0x055F)
        || (codePoint >= 0x0561 && codePoint <= 0x0587)
        || codePoint == 0x0589
        || codePoint == 0x0903
        || (codePoint >= 0x0905 && codePoint <= 0x0939)
        || (codePoint >= 0x093D && codePoint <= 0x0940)
        || (codePoint >= 0x0949 && codePoint <= 0x094C)
        || codePoint == 0x0950
        || (codePoint >= 0x0958 && codePoint <= 0x0961)
        || (codePoint >= 0x0964 && codePoint <= 0x0970)
        || (codePoint >= 0x0982 && codePoint <= 0x0983)
        || (codePoint >= 0x0985 && codePoint <= 0x098C)
        || (codePoint >= 0x098F && codePoint <= 0x0990)
        || (codePoint >= 0x0993 && codePoint <= 0x09A8)
        || (codePoint >= 0x09AA && codePoint <= 0x09B0)
        || codePoint == 0x09B2
        || (codePoint >= 0x09B6 && codePoint <= 0x09B9)
        || (codePoint >= 0x09BE && codePoint <= 0x09C0)
        || (codePoint >= 0x09C7 && codePoint <= 0x09C8)
        || (codePoint >= 0x09CB && codePoint <= 0x09CC)
        || codePoint == 0x09D7
        || (codePoint >= 0x09DC && codePoint <= 0x09DD)
        || (codePoint >= 0x09DF && codePoint <= 0x09E1)
        || (codePoint >= 0x09E6 && codePoint <= 0x09F1)
        || (codePoint >= 0x09F4 && codePoint <= 0x09FA)
        || (codePoint >= 0x0A05 && codePoint <= 0x0A0A)
        || (codePoint >= 0x0A0F && codePoint <= 0x0A10)
        || (codePoint >= 0x0A13 && codePoint <= 0x0A28)
        || (codePoint >= 0x0A2A && codePoint <= 0x0A30)
        || (codePoint >= 0x0A32 && codePoint <= 0x0A33)
        || (codePoint >= 0x0A35 && codePoint <= 0x0A36)
        || (codePoint >= 0x0A38 && codePoint <= 0x0A39)
        || (codePoint >= 0x0A3E && codePoint <= 0x0A40)
        || (codePoint >= 0x0A59 && codePoint <= 0x0A5C)
        || codePoint == 0x0A5E
        || (codePoint >= 0x0A66 && codePoint <= 0x0A6F)
        || (codePoint >= 0x0A72 && codePoint <= 0x0A74)
        || codePoint == 0x0A83
        || (codePoint >= 0x0A85 && codePoint <= 0x0A8B)
        || codePoint == 0x0A8D
        || (codePoint >= 0x0A8F && codePoint <= 0x0A91)
        || (codePoint >= 0x0A93 && codePoint <= 0x0AA8)
        || (codePoint >= 0x0AAA && codePoint <= 0x0AB0)
        || (codePoint >= 0x0AB2 && codePoint <= 0x0AB3)
        || (codePoint >= 0x0AB5 && codePoint <= 0x0AB9)
        || (codePoint >= 0x0ABD && codePoint <= 0x0AC0)
        || codePoint == 0x0AC9
        || (codePoint >= 0x0ACB && codePoint <= 0x0ACC)
        || codePoint == 0x0AD0
        || codePoint == 0x0AE0
        || (codePoint >= 0x0AE6 && codePoint <= 0x0AEF)
        || (codePoint >= 0x0B02 && codePoint <= 0x0B03)
        || (codePoint >= 0x0B05 && codePoint <= 0x0B0C)
        || (codePoint >= 0x0B0F && codePoint <= 0x0B10)
        || (codePoint >= 0x0B13 && codePoint <= 0x0B28)
        || (codePoint >= 0x0B2A && codePoint <= 0x0B30)
        || (codePoint >= 0x0B32 && codePoint <= 0x0B33)
        || (codePoint >= 0x0B36 && codePoint <= 0x0B39)
        || (codePoint >= 0x0B3D && codePoint <= 0x0B3E)
        || codePoint == 0x0B40
        || (codePoint >= 0x0B47 && codePoint <= 0x0B48)
        || (codePoint >= 0x0B4B && codePoint <= 0x0B4C)
        || codePoint == 0x0B57
        || (codePoint >= 0x0B5C && codePoint <= 0x0B5D)
        || (codePoint >= 0x0B5F && codePoint <= 0x0B61)
        || (codePoint >= 0x0B66 && codePoint <= 0x0B70)
        || codePoint == 0x0B83
        || (codePoint >= 0x0B85 && codePoint <= 0x0B8A)
        || (codePoint >= 0x0B8E && codePoint <= 0x0B90)
        || (codePoint >= 0x0B92 && codePoint <= 0x0B95)
        || (codePoint >= 0x0B99 && codePoint <= 0x0B9A)
        || codePoint == 0x0B9C
        || (codePoint >= 0x0B9E && codePoint <= 0x0B9F)
        || (codePoint >= 0x0BA3 && codePoint <= 0x0BA4)
        || (codePoint >= 0x0BA8 && codePoint <= 0x0BAA)
        || (codePoint >= 0x0BAE && codePoint <= 0x0BB5)
        || (codePoint >= 0x0BB7 && codePoint <= 0x0BB9)
        || (codePoint >= 0x0BBE && codePoint <= 0x0BBF)
        || (codePoint >= 0x0BC1 && codePoint <= 0x0BC2)
        || (codePoint >= 0x0BC6 && codePoint <= 0x0BC8)
        || (codePoint >= 0x0BCA && codePoint <= 0x0BCC)
        || codePoint == 0x0BD7
        || (codePoint >= 0x0BE7 && codePoint <= 0x0BF2)
        || (codePoint >= 0x0C01 && codePoint <= 0x0C03)
        || (codePoint >= 0x0C05 && codePoint <= 0x0C0C)
        || (codePoint >= 0x0C0E && codePoint <= 0x0C10)
        || (codePoint >= 0x0C12 && codePoint <= 0x0C28)
        || (codePoint >= 0x0C2A && codePoint <= 0x0C33)
        || (codePoint >= 0x0C35 && codePoint <= 0x0C39)
        || (codePoint >= 0x0C41 && codePoint <= 0x0C44)
        || (codePoint >= 0x0C60 && codePoint <= 0x0C61)
        || (codePoint >= 0x0C66 && codePoint <= 0x0C6F)
        || (codePoint >= 0x0C82 && codePoint <= 0x0C83)
        || (codePoint >= 0x0C85 && codePoint <= 0x0C8C)
        || (codePoint >= 0x0C8E && codePoint <= 0x0C90)
        || (codePoint >= 0x0C92 && codePoint <= 0x0CA8)
        || (codePoint >= 0x0CAA && codePoint <= 0x0CB3)
        || (codePoint >= 0x0CB5 && codePoint <= 0x0CB9)
        || codePoint == 0x0CBE
        || (codePoint >= 0x0CC0 && codePoint <= 0x0CC4)
        || (codePoint >= 0x0CC7 && codePoint <= 0x0CC8)
        || (codePoint >= 0x0CCA && codePoint <= 0x0CCB)
        || (codePoint >= 0x0CD5 && codePoint <= 0x0CD6)
        || codePoint == 0x0CDE
        || (codePoint >= 0x0CE0 && codePoint <= 0x0CE1)
        || (codePoint >= 0x0CE6 && codePoint <= 0x0CEF)
        || (codePoint >= 0x0D02 && codePoint <= 0x0D03)
        || (codePoint >= 0x0D05 && codePoint <= 0x0D0C)
        || (codePoint >= 0x0D0E && codePoint <= 0x0D10)
        || (codePoint >= 0x0D12 && codePoint <= 0x0D28)
        || (codePoint >= 0x0D2A && codePoint <= 0x0D39)
        || (codePoint >= 0x0D3E && codePoint <= 0x0D40)
        || (codePoint >= 0x0D46 && codePoint <= 0x0D48)
        || (codePoint >= 0x0D4A && codePoint <= 0x0D4C)
        || codePoint == 0x0D57
        || (codePoint >= 0x0D60 && codePoint <= 0x0D61)
        || (codePoint >= 0x0D66 && codePoint <= 0x0D6F)
        || (codePoint >= 0x0D82 && codePoint <= 0x0D83)
        || (codePoint >= 0x0D85 && codePoint <= 0x0D96)
        || (codePoint >= 0x0D9A && codePoint <= 0x0DB1)
        || (codePoint >= 0x0DB3 && codePoint <= 0x0DBB)
        || codePoint == 0x0DBD
        || (codePoint >= 0x0DC0 && codePoint <= 0x0DC6)
        || (codePoint >= 0x0DCF && codePoint <= 0x0DD1)
        || (codePoint >= 0x0DD8 && codePoint <= 0x0DDF)
        || (codePoint >= 0x0DF2 && codePoint <= 0x0DF4)
        || (codePoint >= 0x0E01 && codePoint <= 0x0E30)
        || (codePoint >= 0x0E32 && codePoint <= 0x0E33)
        || (codePoint >= 0x0E40 && codePoint <= 0x0E46)
        || (codePoint >= 0x0E4F && codePoint <= 0x0E5B)
        || (codePoint >= 0x0E81 && codePoint <= 0x0E82)
        || codePoint == 0x0E84
        || (codePoint >= 0x0E87 && codePoint <= 0x0E88)
        || codePoint == 0x0E8A
        || codePoint == 0x0E8D
        || (codePoint >= 0x0E94 && codePoint <= 0x0E97)
        || (codePoint >= 0x0E99 && codePoint <= 0x0E9F)
        || (codePoint >= 0x0EA1 && codePoint <= 0x0EA3)
        || codePoint == 0x0EA5
        || codePoint == 0x0EA7
        || (codePoint >= 0x0EAA && codePoint <= 0x0EAB)
        || (codePoint >= 0x0EAD && codePoint <= 0x0EB0)
        || (codePoint >= 0x0EB2 && codePoint <= 0x0EB3)
        || codePoint == 0x0EBD
        || (codePoint >= 0x0EC0 && codePoint <= 0x0EC4)
        || codePoint == 0x0EC6
        || (codePoint >= 0x0ED0 && codePoint <= 0x0ED9)
        || (codePoint >= 0x0EDC && codePoint <= 0x0EDD)
        || (codePoint >= 0x0F00 && codePoint <= 0x0F17)
        || (codePoint >= 0x0F1A && codePoint <= 0x0F34)
        || codePoint == 0x0F36
        || codePoint == 0x0F38
        || (codePoint >= 0x0F3E && codePoint <= 0x0F47)
        || (codePoint >= 0x0F49 && codePoint <= 0x0F6A)
        || codePoint == 0x0F7F
        || codePoint == 0x0F85
        || (codePoint >= 0x0F88 && codePoint <= 0x0F8B)
        || (codePoint >= 0x0FBE && codePoint <= 0x0FC5)
        || (codePoint >= 0x0FC7 && codePoint <= 0x0FCC)
        || codePoint == 0x0FCF
        || (codePoint >= 0x1000 && codePoint <= 0x1021)
        || (codePoint >= 0x1023 && codePoint <= 0x1027)
        || (codePoint >= 0x1029 && codePoint <= 0x102A)
        || codePoint == 0x102C
        || codePoint == 0x1031
        || codePoint == 0x1038
        || (codePoint >= 0x1040 && codePoint <= 0x1057)
        || (codePoint >= 0x10A0 && codePoint <= 0x10C5)
        || (codePoint >= 0x10D0 && codePoint <= 0x10F8)
        || codePoint == 0x10FB
        || (codePoint >= 0x1100 && codePoint <= 0x1159)
        || (codePoint >= 0x115F && codePoint <= 0x11A2)
        || (codePoint >= 0x11A8 && codePoint <= 0x11F9)
        || (codePoint >= 0x1200 && codePoint <= 0x1206)
        || (codePoint >= 0x1208 && codePoint <= 0x1246)
        || codePoint == 0x1248
        || (codePoint >= 0x124A && codePoint <= 0x124D)
        || (codePoint >= 0x1250 && codePoint <= 0x1256)
        || codePoint == 0x1258
        || (codePoint >= 0x125A && codePoint <= 0x125D)
        || (codePoint >= 0x1260 && codePoint <= 0x1286)
        || codePoint == 0x1288
        || (codePoint >= 0x128A && codePoint <= 0x128D)
        || (codePoint >= 0x1290 && codePoint <= 0x12AE)
        || codePoint == 0x12B0
        || (codePoint >= 0x12B2 && codePoint <= 0x12B5)
        || (codePoint >= 0x12B8 && codePoint <= 0x12BE)
        || codePoint == 0x12C0
        || (codePoint >= 0x12C2 && codePoint <= 0x12C5)
        || (codePoint >= 0x12C8 && codePoint <= 0x12CE)
        || (codePoint >= 0x12D0 && codePoint <= 0x12D6)
        || (codePoint >= 0x12D8 && codePoint <= 0x12EE)
        || (codePoint >= 0x12F0 && codePoint <= 0x130E)
        || codePoint == 0x1310
        || (codePoint >= 0x1312 && codePoint <= 0x1315)
        || (codePoint >= 0x1318 && codePoint <= 0x131E)
        || (codePoint >= 0x1320 && codePoint <= 0x1346)
        || (codePoint >= 0x1348 && codePoint <= 0x135A)
        || (codePoint >= 0x1361 && codePoint <= 0x137C)
        || (codePoint >= 0x13A0 && codePoint <= 0x13F4)
        || (codePoint >= 0x1401 && codePoint <= 0x1676)
        || (codePoint >= 0x1681 && codePoint <= 0x169A)
        || (codePoint >= 0x16A0 && codePoint <= 0x16F0)
        || (codePoint >= 0x1700 && codePoint <= 0x170C)
        || (codePoint >= 0x170E && codePoint <= 0x1711)
        || (codePoint >= 0x1720 && codePoint <= 0x1731)
        || (codePoint >= 0x1735 && codePoint <= 0x1736)
        || (codePoint >= 0x1740 && codePoint <= 0x1751)
        || (codePoint >= 0x1760 && codePoint <= 0x176C)
        || (codePoint >= 0x176E && codePoint <= 0x1770)
        || (codePoint >= 0x1780 && codePoint <= 0x17B6)
        || (codePoint >= 0x17BE && codePoint <= 0x17C5)
        || (codePoint >= 0x17C7 && codePoint <= 0x17C8)
        || (codePoint >= 0x17D4 && codePoint <= 0x17DA)
        || codePoint == 0x17DC
        || (codePoint >= 0x17E0 && codePoint <= 0x17E9)
        || (codePoint >= 0x1810 && codePoint <= 0x1819)
        || (codePoint >= 0x1820 && codePoint <= 0x1877)
        || (codePoint >= 0x1880 && codePoint <= 0x18A8)
        || (codePoint >= 0x1E00 && codePoint <= 0x1E9B)
        || (codePoint >= 0x1EA0 && codePoint <= 0x1EF9)
        || (codePoint >= 0x1F00 && codePoint <= 0x1F15)
        || (codePoint >= 0x1F18 && codePoint <= 0x1F1D)
        || (codePoint >= 0x1F20 && codePoint <= 0x1F45)
        || (codePoint >= 0x1F48 && codePoint <= 0x1F4D)
        || (codePoint >= 0x1F50 && codePoint <= 0x1F57)
        || codePoint == 0x1F59
        || codePoint == 0x1F5B
        || codePoint == 0x1F5D
        || (codePoint >= 0x1F5F && codePoint <= 0x1F7D)
        || (codePoint >= 0x1F80 && codePoint <= 0x1FB4)
        || (codePoint >= 0x1FB6 && codePoint <= 0x1FBC)
        || codePoint == 0x1FBE
        || (codePoint >= 0x1FC2 && codePoint <= 0x1FC4)
        || (codePoint >= 0x1FC6 && codePoint <= 0x1FCC)
        || (codePoint >= 0x1FD0 && codePoint <= 0x1FD3)
        || (codePoint >= 0x1FD6 && codePoint <= 0x1FDB)
        || (codePoint >= 0x1FE0 && codePoint <= 0x1FEC)
        || (codePoint >= 0x1FF2 && codePoint <= 0x1FF4)
        || (codePoint >= 0x1FF6 && codePoint <= 0x1FFC)
        || codePoint == 0x200E
        || codePoint == 0x2071
        || codePoint == 0x207F
        || codePoint == 0x2102
        || codePoint == 0x2107
        || (codePoint >= 0x210A && codePoint <= 0x2113)
        || codePoint == 0x2115
        || (codePoint >= 0x2119 && codePoint <= 0x211D)
        || codePoint == 0x2124
        || codePoint == 0x2126
        || codePoint == 0x2128
        || (codePoint >= 0x212A && codePoint <= 0x212D)
        || (codePoint >= 0x212F && codePoint <= 0x2131)
        || (codePoint >= 0x2133 && codePoint <= 0x2139)
        || (codePoint >= 0x213D && codePoint <= 0x213F)
        || (codePoint >= 0x2145 && codePoint <= 0x2149)
        || (codePoint >= 0x2160 && codePoint <= 0x2183)
        || (codePoint >= 0x2336 && codePoint <= 0x237A)
        || codePoint == 0x2395
        || (codePoint >= 0x249C && codePoint <= 0x24E9)
        || (codePoint >= 0x3005 && codePoint <= 0x3007)
        || (codePoint >= 0x3021 && codePoint <= 0x3029)
        || (codePoint >= 0x3031 && codePoint <= 0x3035)
        || (codePoint >= 0x3038 && codePoint <= 0x303C)
        || (codePoint >= 0x3041 && codePoint <= 0x3096)
        || (codePoint >= 0x309D && codePoint <= 0x309F)
        || (codePoint >= 0x30A1 && codePoint <= 0x30FA)
        || (codePoint >= 0x30FC && codePoint <= 0x30FF)
        || (codePoint >= 0x3105 && codePoint <= 0x312C)
        || (codePoint >= 0x3131 && codePoint <= 0x318E)
        || (codePoint >= 0x3190 && codePoint <= 0x31B7)
        || (codePoint >= 0x31F0 && codePoint <= 0x321C)
        || (codePoint >= 0x3220 && codePoint <= 0x3243)
        || (codePoint >= 0x3260 && codePoint <= 0x327B)
        || (codePoint >= 0x327F && codePoint <= 0x32B0)
        || (codePoint >= 0x32C0 && codePoint <= 0x32CB)
        || (codePoint >= 0x32D0 && codePoint <= 0x32FE)
        || (codePoint >= 0x3300 && codePoint <= 0x3376)
        || (codePoint >= 0x337B && codePoint <= 0x33DD)
        || (codePoint >= 0x33E0 && codePoint <= 0x33FE)
        || (codePoint >= 0x3400 && codePoint <= 0x4DB5)
        || (codePoint >= 0x4E00 && codePoint <= 0x9FA5)
        || (codePoint >= 0xA000 && codePoint <= 0xA48C)
        || (codePoint >= 0xAC00 && codePoint <= 0xD7A3)
        || (codePoint >= 0xD800 && codePoint <= 0xFA2D)
        || (codePoint >= 0xFA30 && codePoint <= 0xFA6A)
        || (codePoint >= 0xFB00 && codePoint <= 0xFB06)
        || (codePoint >= 0xFB13 && codePoint <= 0xFB17)
        || (codePoint >= 0xFF21 && codePoint <= 0xFF3A)
        || (codePoint >= 0xFF41 && codePoint <= 0xFF5A)
        || (codePoint >= 0xFF66 && codePoint <= 0xFFBE)
        || (codePoint >= 0xFFC2 && codePoint <= 0xFFC7)
        || (codePoint >= 0xFFCA && codePoint <= 0xFFCF)
        || (codePoint >= 0xFFD2 && codePoint <= 0xFFD7)
        || (codePoint >= 0xFFDA && codePoint <= 0xFFDC)
        || (codePoint >= 0x10300 && codePoint <= 0x1031E)
        || (codePoint >= 0x10320 && codePoint <= 0x10323)
        || (codePoint >= 0x10330 && codePoint <= 0x1034A)
        || (codePoint >= 0x10400 && codePoint <= 0x10425)
        || (codePoint >= 0x10428 && codePoint <= 0x1044D)
        || (codePoint >= 0x1D000 && codePoint <= 0x1D0F5)
        || (codePoint >= 0x1D100 && codePoint <= 0x1D126)
        || (codePoint >= 0x1D12A && codePoint <= 0x1D166)
        || (codePoint >= 0x1D16A && codePoint <= 0x1D172)
        || (codePoint >= 0x1D183 && codePoint <= 0x1D184)
        || (codePoint >= 0x1D18C && codePoint <= 0x1D1A9)
        || (codePoint >= 0x1D1AE && codePoint <= 0x1D1DD)
        || (codePoint >= 0x1D400 && codePoint <= 0x1D454)
        || (codePoint >= 0x1D456 && codePoint <= 0x1D49C)
        || (codePoint >= 0x1D49E && codePoint <= 0x1D49F)
        || codePoint == 0x1D4A2
        || (codePoint >= 0x1D4A5 && codePoint <= 0x1D4A6)
        || (codePoint >= 0x1D4A9 && codePoint <= 0x1D4AC)
        || (codePoint >= 0x1D4AE && codePoint <= 0x1D4B9)
        || codePoint == 0x1D4BB
        || (codePoint >= 0x1D4BD && codePoint <= 0x1D4C0)
        || (codePoint >= 0x1D4C2 && codePoint <= 0x1D4C3)
        || (codePoint >= 0x1D4C5 && codePoint <= 0x1D505)
        || (codePoint >= 0x1D507 && codePoint <= 0x1D50A)
        || (codePoint >= 0x1D50D && codePoint <= 0x1D514)
        || (codePoint >= 0x1D516 && codePoint <= 0x1D51C)
        || (codePoint >= 0x1D51E && codePoint <= 0x1D539)
        || (codePoint >= 0x1D53B && codePoint <= 0x1D53E)
        || (codePoint >= 0x1D540 && codePoint <= 0x1D544)
        || codePoint == 0x1D546
        || (codePoint >= 0x1D54A && codePoint <= 0x1D550)
        || (codePoint >= 0x1D552 && codePoint <= 0x1D6A3)
        || (codePoint >= 0x1D6A8 && codePoint <= 0x1D7C9)
        || (codePoint >= 0x20000 && codePoint <= 0x2A6D6)
        || (codePoint >= 0x2F800 && codePoint <= 0x2FA1D)
        || (codePoint >= 0xF0000 && codePoint <= 0xFFFFD)
        || (codePoint >= 0x100000 && codePoint <= 0x10FFFD)
        ;
  }

}
