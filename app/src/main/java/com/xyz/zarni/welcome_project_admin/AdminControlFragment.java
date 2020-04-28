package com.xyz.zarni.welcome_project_admin;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.ui.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminControlFragment extends Fragment implements View.OnClickListener{

    private CardView c1, c2, c3, c4, c5, c6, c7;
    private Switch s1, s2, s3, s4, s5, s6, s7;
    private DatabaseReference mUsers,noti;
    private TextView text;
    private FirebaseAuth mAuth;
    private String first[] = {"VGf52FRY1qPuFapmoqeTJBzYwW63","VOS4VOXM5hNZwpZW2QRcPXM5YPh1","VVvpTSAa2fQDTMRLk5QdmbLSEfQ2","VogVJtQL8EQ7KoUStvkd7qe9mjn2","VpHvCuM8NXf1Drg0STTZKsNDtgE3","VpNd0pD5ZGRBGdXLFTWdbtg66Ji2","VvZ3oiN5TEgmrIXyWkMHKHUghLJ3","WHqG1ydl6lbhI1dXcCfbESAx75R2","WTRtA4mJ21MTpTp3uLMWkgf7bGe2","WvChUmOMfLhpZ90jPqkkvNMRRZq1","X7ATQrzEVIQJAvnVFjQ1DisIL0l2","XU22lh1fLHQKcgjQuHhoscVfBst2","XqdRWwAg3sUHyLIGqSPdPFlZrvo1","YwVVh3K1CBbRzARCO9VpZDmyZ1x1","YzebotaD5Aar1CsQDjaIop0et603","Z7Nr9ZmoYTZnRfpC4bSQP3oRCfg2","a43uwvKwYkMT9Ou5vBw8PVPvPeH3","b7m3aGoeaUVWyGiiegpLPjx6D273","bxGMWygsXKcBNzun2CMAmq1Z5z53","c4s3hlWv5tS1QAuL79E3jUNtP9I2","cmFPeGdXaQf5enWAStzlFRtQnMm2","eA0dlhiusLeAQ11n51INKUmaXIP2",
            "eh7nkHM3rsXBczsQXId4N2HOIZ82","fMUxu652TAO9sWXGilC02ZT6gc73","gDKaMwHz1JRM1SQpxdxqd54TArz1","hlSWMB9KF9f8S2LimHfbQFIjZlF2","hy34eKjWJxcuQ01rS7oXfSyKjAp2","ihAW9V6J38YvpO50n13EKeKb5jw2","ij2x3V0w7oYVFD4GeGuBVwdfNJw1","inBa0cAwRudjvbFglaqbqKYqyr53","irGIP293qUQjYqpQQpNdCnrF0p73","jXWmORlU0cbAIE5AB6vxXheutIG3","jyY6dsO5C8glnuICf4sMyVuwdDu2","kJJTZr3EStONBgcMuZYCMtc7lRg2","kSucrKDKLsSz66RhPpT46w3AhHv1","kmwcuNRdzIRSShR05byupFjxcLh2","le2Ms2XuyNMdMHJ6sXiDCLrakor1","yxEeLHtfOWdSVBA6qqOySteeBf92","yRuamWfgVvc27NmqPaICDA8soN22","yPyio8xAXwdlqSCXzatSFXkzSoQ2","wyhIexYa6RcIpfxLEEia6FMXpHw1","wmARvs79kShp6gUzsKLNjQjnH3W2","w410iIenjmMrLdqyuTBrG2wvLJy2","vYHLRgGWrmeDcNCJyAPbenPmYze2","vH3keO2vznUs3MO5OSyGuUVEVRu1",
    "uUcTnwRJUKQoaLESDmrBTjxrWdJ3","uI2nTamXTZQDTdzmOd8q2HrRrr83","tJoXRyIh1RgqfpGeC7vbt1bMvT82","t2GytfrZILhHhQlxDP6PdXc3A0Q2","sT0L7EOCoue4Kfyj05WiO4rLDx63","s8kS1m92btbhy4qRplGFXcoZKlw2","rtCK1yFAg3Zj5JoPZmexnknbJhi1","rt1jaIP6VAhpLrFDBWuCCg90gVw2","rbp21aU2PNTP7ldwfgxnBwbGV5d2",
    "rVfp0ab7QUfqN8nqSmEHmkpojTv1","rLT8aKNMN6XtfdOF64cLI7Mrx3x2","qoIv9oqCYwPwPfAxRfO0tsqDTSi1","qXjHMDO47SgLC4i0mIhchgwtTE03","q1ervpfjx9X7Uskh71G6uaImxi52","ocLQc9NEsRb03HYnU64U8h2VuKn1","0rxJebHKfPUBk0iVg9YOHB9vXNS2","1hSy1dEBviXWLLdQDiqK5c3htPV2","1tLNtBfpLKg9eFVHhflkh8bXScL2","2GS7oFegtiWXW9sggh9KBrvheBw2","2xOZRuqXR8axycnJyOMmUNaJ7RN2","39VDnsoV7OUWzfAloBV9RNvcXRq2","3KalcGu6HAhKoLeWnCQK05I1o9z1","3aFe0lHW42crFmfboTnQC3kh3EL2","40Nl3xXtEThQvAvGQu1S7UWyMNx2","42DOryaa5vRtKPKYI47TBqzKDYV2","4K18nKBn98ZGrfYczTEcXHthTOw2","4Ur2zrpJ3raicwqRa44VkJZcHXy2","4eGo9mSkQkVhJQrtckX4fhOdZPm1","5nSaeFd9SPgnWPVtzhKD0D4c0673","74DBW0EXU2aig1n1Cp4LMLpDM9u1","8Cdb7bWM5wgWjQsiqQkvZH2bR0Y2","8FoDaTGM2gRaJGu9AxWi9Md4eoq2","8lfDaIhXhYd8dvJjL74LhxJ2TKK2","8u0lsrw5N3NM5IB6JoyccsHXcka2","9P0n0L80zkOlA9I1Ubl5CpOoN252",
    "9TkxBvaSW4Uabi4dqHzMRXzo3Im1","9bgkayWeM6YqfHlAGCxiawMCapl2","9gXcET3TNFXnwTWMGu9Yx26JPsw1","AvZhJ0TJd9ZQ3hOlyacLZlaCAlw2","C4rYO3Cs3sf7ERe9qclM8ABKDtm1","CUugTSWl5Ze0GALLR09MfbQuzr52","Cee0L0g4whX0pKY0IRXQgKQqTJw1","CsDPE940bcMuDbTVoTWUzSDuQVn1","D2h8N6rCqyeLZRkqQiejo681kZj1","E127BNKjcqXeInANINYi4b1GhgN2","E5FJeZaEweafZQbjtzkSVIIEXXg1","EVHOAsDrO0MAQ6r6aHBe0m8blFf2","EaCQTg5Va3dOb8jB2rONTZnkNWL2","Ee78Gbhyf7My04YeAaPCuZkdi8o1","EoHPLHsoFFVvGeAuYepiktDRLiQ2","F1BeXITtQMboGTZdLlw1RRqLodI3","FFxaXCbXlMNzpqQrwUeuqTL754U2","FXhA3KAQCkX6LcibFrwlSUSgmNR2","FqtBlcdenYVi7EvMbAFV50KBhd43","FuQWOACPzGRQGH1fiPf5qQowN7w2","GgyDiOssn6PcbdKbASjP8BPl0LD3","HRZvVAYK0oPK4LtjkV4gi71LVcI2","HZfgk8jlh4Vfqjh8DNGWGcqT0hR2","HzYAalGeMVdGKzPYMW4OT3Hz4oT2","IHZFXIPUYIdvnleBhyBCvmcSadU2","KEPm1rDFQZZszOcsywpu0iJRD2q2",
    "KrSDqgXYQ5V4rsv83Px7yYIIhjC3","LCr6cLQlXvbg3oUQEMKDXCdhQCe2","Ls5XvTrJlgVCEQ9S4t0QUIN8ffY2","Lv2aCaSRpVUrCc0aWfu2ZlmDj2k2","N0OUmur5qNTgrurPAcbdxVrHZxu2","NaLm8NsQXSfMA553p0I2XcgtRIl1","Ok0kM4PU38TPfDq8SvosweHnJX63","P5W27X6q3jNvzDGR8atcyd4vYCg1","Q7yTNNo1Zxa47ngRrewqYgDU20x1","RguKC7Lq9NQmMeaWEZ2TzyfYkmY2","RkEswHa1NnR5JM3jOnw8ftH56W13","T3JRATPFVbXrN9Uu145TCdljvIj2","T4J5ey2AhcNwBtcAveMJbdxlEmN2","TAMzLd3aOiYxwIOznq3WQcqWnlo1","TJgpajzNQ2cldXEZ9vo91Dgl2xl1","UcksDGKXb2OGybsWru1gO1yzwD03","Uidl05Kt1wQYEHt0kJL0oDy8kvj2"};


    private String sec[] = {"B9yMbjSGR6bFVxsp3eZJQX7lOTN2","IJnaNkCb9GSivgaZ0RNmQffX6tH2","c78gpSJ5FzftgtoPvgAF4CrK3Rf2","tn9ufOeyrDXn9G12HLF5ScHIprg2","W5OgZmT7vwdWdhL6mYf9FsnU9pD2","wwuIF9rpiEMPCMKUvMJqNBk20Tb2","Lmfc1yLEIzTXjYjnPj7sUWth3xq1","tjQLI7xh2hfY1qnIFh7bTk9UrEh1","VLdVYe9jVzbeg2vGMAPzYrVVmug1","plWKIAhhnWdOH1dVdDYOWGYBNix1","sjT1YvAi4pY2KKu4MK9tWBQJMwt2","w6NsVFUomDbgN6LfvXWX98Y8kcp1","O6El1PWev1f9PX24SXC3QRV0Rde2","8co0CwnBMDZxxPElPaAM4DHZKTV2","wfNIIQV2NVOFh1Q0Z50By1TU37P2","ajJLhGubhDN716Rln1y7Z884PsM2","StAmmEMnmyUgRl6MT4gfVFtPLZ52","fpvAEh3qJ1T9H4XiwkOBsaXlL5V2","pxDr9QbclIQDz5K6SGbwF88dTXY2","uypsMpzRqBOSxpIIdQwYIBmWWD32","XFkOFkl2XWbj6adyIJjiscGzyVR2","stwKx8oNCqMffXzEd2hKZvbJkoI2","tUcG8hF2vfV0J6RtpAVMt1VqtXr2","nQjAPhjtrUSaAx5PdrsfsZSxfB83","bUeJDboQo6ceNjvNNQc2H3JCPL72","VBixxDiMUFQhuWHaA3kNKgwV5ag2","Tlhbzo9yJZRwCsZFRRahcECSV313","Qfn2svLbzIg3sYSke6x4YIN0ZpI3","mbnpT6cp1eZCyTKVqIeJlN0flKS2","KbBgSrCK64aexoxkTMVpp5ygNWz2","R4r3AQRaVTf83mpEmCPbJcd0O6n1","hPx07K0vBNaff4H8sUCGubyXN1g1",
    "dYmD4cDDqrd9XfMAziMmJg7QkER2","Z7x6QnljdRgFWMufVAcmnD62NQ73","6tZMiU3l62c7YQkiD6mL3DB7rTI2","ijvAHKLxZIWM2dIk90vbgZqZixD2","cAc7S51oy3b6Vh7HzThJuYzomxH3","QUCkFYxqorWq4hmu7HvcZHkhIFE2","qxEucw2GyKQsMwghDORmTjGja0I2","iKHne5t27qQOvM3s4A8YWGn2TeP2","X19FkD2bo8fS9FkZ6RbPTWkKxSd2","RDjKkRA4htZwm9Jgic7yOdWWkez1","y1wHxCxzmqOVWzWn5o53AeieLFw1","FCCHNICnU8R6hUxvfItyxhmVCO82","QqMkfNS7nwdQYIhCdPa5aFqREHC2","6HnzSjE4zKS9h3JyRycwdKEn9ro1","DGNbA9moazaoOBtb9Ef1S40wKtA3","XEQSW2LQkOeWyuwkGoOlR0AEiua2","H6Ft0snekUQLYlsdozVgl78TTBF2","w6Kl4xJyjuNkIbmRpEATwthUImF2","VAeetJqqBUNl5KQUJpIvR8sxkHz1","vWAE2iFw2CZomibgRrMbtOWvpVg1","sjmAKHJ1itVvktpuE8tRq1RDxko1","ZS5XsrTDb1eJlY17F3MGfiX2q8F3","g3L1IG0CK8MmmgzK3lm4Avneo4X2","LefLPKxV5aMQP0odnw6LKBlBRwU2","mShpeoFJwnMUSkZJwgCk2P7rFa13","7VAhAehG9wRrrYNCBXIY5n6q2SG2","eH3rl0V5sMOTnWTEhapdxJMBSdJ3","9QAW3cYaniRZfvPBZkAUYuxcNNy1","hGt6QtfxD7cWfxFlgpSEtIwjOSz1","pc49u8d7Y6Nx0ByzcNUROkbd4Xh2","HYSbTPgArxaY2ofOS98SzHheMZn2","CJQtqveBjWde7UpGzOo8yVBAhCx2","AcCAfdansyQ1Uut6ZbJiHDHG6lG3",
    "VyweqlBXMyazfKm6TxhwLlpD1pV2","f9aAvvAYBmUYm8yV50X2YrkHL0d2","GPk5iTM8SifZOmWci1inAUGi6ot1","fnU4WAYFSuYo8EnvlmdouMem0Qk2","FoO2PiuRbITPuz409OWTNjJUX5f2","PwcvJ1VfOCMWJPZPWoD4WeFchPL2","QKvYITDclhRHjaMvYcf4nKQAlVj2","R55XKBRXrGeq3OFJTa8r32XcZ1E2","xYk0pVJbmzX40jKUroxandd8oK82","81ec2DmPAzMJFJB0mRBdHICwZfT2","Oeq72zYtvEh1XEMuiKWN1tePs6j1","gf6whZpM9bV87Bd16EFRC5Rfo1v2","FR7xmVHaZIbDe6Gvx8Juzuj51Il2","X73O9yI1Xcf0fibhJvQPD4GaZaC2","YlY83wHkJ7MXh7nLQDuHs6Ryy0q2","h2vugjOQlDYPhaqp5ArvMN2tJ7j2","oRodzEJAXWbJr4pU8yvwHcAmGbJ2","Y22ZRL525vZHRfnprFdAuX5bYsH2","Cq5FHPDX6sYPk9Ya9inGaVp7Clk2","aMkUwATMUPfqAhCQ7w7q89vDwdX2","psD8pl2iOGWL7EqzLEIyQe7Uugb2","0KpmLkdDSbYtsow97ZOOZPmNq1t1","aI0CgQqVm3W9c2kr8uxXHQN7TpF2","AN9Frb7qzQdYMUy8NZweyb2JInr2","CxhquDLWulgG9RGdluv8MtbtFQg2","LdKt5ZuKTGeHCZM5ECTsi41ykal1","TGTlweIpS2eKcoA4YDvhRNLQ5x33","aZFqRBt577PYKwSB0HTqRvfJXLj1","rxMiSDixMiNdaWBp7SainYW4ar53","GZznm8pxxfMQlDDVUwIBz6VSeU52","n2AFeSDjXBZFNR8htGetmgcD5xD2","JBPfoyNVDEb5yQy62hkWY22xZpH3","1zTSmJMUFceuZPTymejSkIRR5pC2","PR1IJgmPrFgWroQNwAasfNqUWMs1","yKLkTKgkTkhZOZitz4IfX0j92pG3"};



    private String third[] = {"WE3kUmi0OxVCn8hPayfqtvKNjmY2","ZVyNHeWAuJZ801YftElJHGcOdlS2","dOcnZM51THaKQKObFWfuTTsTIoU2","r8bFqCRwQSdsWrzsgyVwOtsAYPP2","qXPCECy1BwPoIyTCv2dJjGlOOKv2","QffrHi4nrIac5RIydjNK9fSgfjK2","XA8dKQ5OlEQUxSCsIRRRDCESo9a2","GigzF2RUfHa2f13qZZ15CZas0GP2",
    "fr56jv5SzAQ716hwmFlnNUzAf5X2","dXLvT17uQOSotXPo5KqTKS8QVwN2","BQoB1zimbuRarTS3jhyguUYy2hc2","atS7KvMnsPY4umYR85nEnPLZTgx1","WbX4JjJlmzRgNammOkt76knf4gj1","NXcHcunpVwQkr7mie4NN04gw8ZU2","TtSbrSNRVqZl5oBPRYz1TjuCWkw2","TtSbrSNRVqZl5oBPRYz1TjuCWkw2","fOUKroyNUvh3W7BedXK3v20UdsE3",
    "MR63hExhtSQuSWlN7FrM94McT2H2","93QsSfzht8UpCBDhwgGHnQ2kSw83","OetL6XuNLigWEBAq3RJdhZRoiJr2","bov1Tj38vLX19QoIqCrsnUaztpk1","7LVgOBannuejuaz1hnP6FoVqVZj2","eUuKVOCwnraNEMDTQ5DnnNhXKot1","i7Oy2Kv0Y4eeR1eAB1isMHgHhfZ2","xksb1lnx6EVOtXhqgqY6VSKhEqE3","4xGtvMYT41WVGLmHDJx4JTnCZo83",
    "nKMg4dblQzZzSFfF1BnKKF2jQPr2","oBTVoC2lN5V1xDkIcWOnsp0m3o53","e2wS1qRST1RDXdJrSykq86Nn6Hw2","M6ktYHE0jDWxThHeIbsMszwO0sV2","OrZosZlXRZVuajN2NiyaUr5Brtx2","cscPg4QJ22OiQbn7mJaJXHNB6ot2","RmAf0Up1d7WQBvnG3Hqgx8Cnw9x1","nyRESUnRqXPnMwsxWKgDlJTZKae2","pGWBzlVmljWon7WzWj8mj6hSlrB2",
    "QTkKsJn1FjPi5ozc0ODHBZmUsNv1","axaarg5jOiOuTzXGfjsLMvE7srx2","SE08SN7YLwWyCGdEBzERtpBCwR32","MW3kf8BDpIO5p1NP90DrpZk2bUh2","8WnTtsuZfYWLtAIQsOdsciQTONY2","pFcrZVAiTDYxYvhQFjhNSQeoMWh1","KrVpchhQ8yZIaoFHZHibWB8G6pl1","aLNjwqmLDzeNHx1NZXzmIDPN4k62","McQstRnXqyXeAjHmLLHqaItlBbB2",
    "VRl6RJqKH0SO7OJ6I7Kx9uSTcT33","jVf2xAaRN7OJ62YEago9UvFBU432","mUrKkKqEM8U5ZyLBJzAmeSmFszM2","NBTzt46ti3M9OE0LTrxJbi2UgcK2","X8NqDgEsofYSpSHpzu24mqF2Wkp2","U1Tsdq4JjWVWQZwCCW8umNWm0Wq1","cRYfoM0bOncHxJ0UxXFQlxvJEhX2","DwQIkYcPK8ehh6Wcm7aVzXLWED82","uUINxfz89FeBqOE9BxJOxpc2ugl2",
    "QXu7VToPrQf4fjLrvVKQ1oZ16n32","Lo7VNterm7aiH71Q0YKk6CAxqFi1","zFE5z53yQWPbbb0ZcNAu2GxgxtA2","iRiD3Oq3sYea5iGkz5s1gQyleE42","L7kv6fclc6fbyjQGCULZnkb3r292","pdebjBRA5JbOIQ7lMEldzqcQMzE3","sQ0NbfAURAXYGpjTK9ELrkSzpq83","NUCiiSwKNRWROp0sDFpeVtIv5ue2","VMiRBhqPaFPlxjhbcnEidQuhkEH3",
    "3WcTRTsWL7f2Yo1bFxO1rz9Cngn1","gNssuwbdL8UZ1K2XRHBoaU5y2g43","jZmCl3wxgRM7jaegpMN0GQ9vp5g1","6KPGmSFIxMcF3QzX2BPDZ344WS32","7p51vXGxkPXhU6il3hvbDmGiPKj2","AlCmmjTa0KahLk1IBkY5E2DFtWf1","BYrHIIn1BrS7CN7QySEcitetFj43","5CQZed7Q4Dal0Y2tjC9WVxHI9622","5JgFjuDSDsQdbP9EWAPwLv66ql73",
    "UP1YuVwO63S4H9WYXOvsxol4uWm2","ZcOjrtvL5cT46tXRL4niTQyGdZf1","LJ8h7EPUXTYTvhjUttmwienmUSX2"};

    private String fourth[] = {"AjU11MQqkxXKjlIgRGiJmDtK07i2","uRWAiTp0HWQnLNLMk5FUYDA5XD53","QACuZJWbvcWYoI5cVbNDT51XlZE3","64hxxicU5KSF8WBa2jqO3lFURYy2","VhqlPTLE3TS8vJMbtJQWRgRAG8s2","UygOghmRTOTeFGqjzC36kAVsTdr2","6ixPJFaG3PMsvpRhYIQMYe4cfQq1","1HaZDDYib9bpA5yaXbqd0JRWH3q1","hqLkjcWPyqUSj6HliFQ6LSwIEE72","sIVJRt9GIoSYJfCwjoAkijWVLOl1","nF5Y0yojombUFna0kH0tB2ccvui1","XhiXyCzcAZgnWR5HCRXyzK9yb623","C90KZ064NbfdH5JfNikiwl9Hgug2","IMy6JttXvoXMjNscAt8XXzOHTN52","Leye3OU6teMIGCeyqY4jQyDh3zo2","neBwYExgZFPuyDUMLX1fkF9C64i2","O2z78i6nxgOyydVQiyxNpoUaNez1","WQuKTVfo9gONxWNLpLuusjRh1Br2","WQuKTVfo9gONxWNLpLuusjRh1Br2","xhaqZSWm25N1JjG3yuO6QxQwgeA2","SnhG54qH6lOBNN5KROKIGl1PrCu2","OYhezhKJ1BUvtdh0RZlkbxTxcCB2","GlLJlNwiFPQPsuaXgHOfyazIgI03","WNaZcTGYH1eezI9CWuvNwMyIkmT2","fbRoIIFPOjQDGeyAcOvvl4gpjgt2","3P4W74hkcFhKqWTsBYksZthe5Rf1","jmOkhdODmldfuRQW8luyjYX0JE93","RMgWnOz9fdURATJspVGGzmA39Yf1","9ePmRROeT6ZSEGHSTF32Ufk9Bhi1","IctizV8Y4yPZqI4pSuKymn9Or3K2","pGN3eq6Y0ROIG7JAsD7ekHe7Pwy2","mySTx0zMj8P6B5muRONhphShums1","WGi9fpT8e4PzxIU39Asez6zzKuW2","BCdVPupr1FgH0bTlPUXQvQINwbm2","x3m79iOWkEavtBAQA12PFcoXGE42","VhqlPTLE3TS8vJMbtJQWRgRAG8s2","64hxxicU5KSF8WBa2jqO3lFURYy2","lCNLZiS4O2dWkidkN152iLn1qdg2","QACuZJWbvcWYoI5cVbNDT51XlZE3","uRWAiTp0HWQnLNLMk5FUYDA5XD53","AjU11MQqkxXKjlIgRGiJmDtK07i2"};
    private String fifth[] = {"cyVHhzeVTzQH5J7SQbCEtkVy3VJ2","SZcoqXdQfGYunrHvxJDUM5nBE6S2","DVhpGJk4SFSeS0GmjDQeEjwWVlo1","lCVdoCkbeUR2BTfnrN4r6eRfNA62","SWCbzoLZFaM5kCpvETQ0UL0VAh02","ZsUqGafZS2gZslbp4RmVIDfeklg2","iGLfXt5QM1huGzFHtf7Fw23moK42","LzWhwwUf9dcFEvvl4GoyWflXM6A3","ObJWfDC6ycT6LhZPfHq8RiYGyYk2","XZSg3kgdjpg1lNj9Ty0ktyfiwYG3","sdzE2SEhmISH9goiERRCarrYGn02","evBWMVl5XghQCBMoryNtrRzbks93","aQr60cwQEHakdIuMv8FFa1a84D43","8xX4V1bPsSfFAjRy9DAKfEUMa0x1","M6uXyeYBYgfh9o9gbxKWYOvZOYd2"};
    private String teacher[] = {};
    int i,j,k,l,m,n,o,p,q,r,s,t;

    SharedPreferences share;

    public AdminControlFragment() {
        // Required empty public constructor
    }

    //ToDo create users id array and loop for it / and check it /

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_admin_control, container, false);

        mAuth = FirebaseAuth.getInstance();

        mUsers = FirebaseDatabase.getInstance().getReference().child("Users");
        mUsers.keepSynced(true);

        share = getActivity().getSharedPreferences("Open", Context.MODE_PRIVATE);

        text = v.findViewById(R.id.text);

        c1 = (CardView) v.findViewById(R.id.close_all);

        s1 = (Switch) v.findViewById(R.id.close);

        c1.setOnClickListener(this);


       FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               if (dataSnapshot.exists()){
                   for (DataSnapshot snap : dataSnapshot.getChildren()){
                       Log.e(snap.getKey(),snap.getChildrenCount() + "");
                   }
               }
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });


       Log.i("First ==>",first.length+"");
        Log.i("Sec ==>",sec.length+"");
        Log.i("Third ==>",third.length+"");
        Log.i("Fourth ==>",fourth.length+"");
        Log.i("Fifth ==>",fifth.length+"");

//        for (j = 0; j< first.length-1;j++){
//
//            mUsers.child(first[j]).child("permission").setValue("not_allowed");
//            mUsers.child(first[j]).child("kvote").setValue("0");
//            mUsers.child(first[j]).child("qvote").setValue("0");
//            mUsers.child(first[j]).child("year").setValue("first");
//
//
//        }
//
//        for (k = 0; k < sec.length-1; k++){
//            mUsers.child(sec[k]).child("permission").setValue("not_allowed");
//            mUsers.child(sec[k]).child("kvote").setValue("0");
//            mUsers.child(sec[k]).child("qvote").setValue("0");
//            mUsers.child(sec[k]).child("year").setValue("second");
//
//        }
//
//
//        for (p = 0;p<third.length-1;p++){
//            mUsers.child(third[p]).child("permission").setValue("not_allowed");
//            mUsers.child(third[p]).child("kvote").setValue("0");
//            mUsers.child(third[p]).child("qvote").setValue("0");
//            mUsers.child(third[p]).child("year").setValue("third");
//        }
//
//        for (l = 0; l<fourth.length-1;l++){
//
//            mUsers.child(fourth[l]).child("permission").setValue("not_allowed");
//            mUsers.child(fourth[l]).child("kvote").setValue("0");
//            mUsers.child(fourth[l]).child("qvote").setValue("0");
//            mUsers.child(fourth[l]).child("year").setValue("fourth");
//        }
//
//        for (o = 0; o<fifth.length-1;o++){
//            mUsers.child(fifth[o]).child("permission").setValue("not_allowed");
//            mUsers.child(fifth[o]).child("kvote").setValue("0");
//            mUsers.child(fifth[o]).child("qvote").setValue("0");
//            mUsers.child(fifth[o]).child("year").setValue("final");
//        }

        String value = share.getString("Condintion","");
        if(value.equals("close")){
            text.setText("Click to Open Vote");
            s1.setChecked(false);
        }else {
            text.setText("Click to Close Vote");
            s1.setChecked(true);
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.close_all:

                if (s1.isChecked()){
                    s1.setChecked(false);
                    SharedPreferences.Editor editor = share.edit();
                    editor.putString("Condintion","close");
                    editor.commit();

                    closeVote();

                    text.setText("Click to Open Vote");

                }else {
                    s1.setChecked(true);
                    SharedPreferences.Editor editor = share.edit();
                    editor.putString("Condintion","open");
                    editor.commit();

                    openVote();
                    text.setText("Click to Close Vote");

                }


                break;


        }
    }

    private void openVote() {
        for (int a = 0 ; a<first.length-1; a++){
            mUsers.child(first[a]).child("permission").setValue("allowed");
        }
        for (int b = 0 ; b<sec.length-1; b++){
            mUsers.child(sec[b]).child("permission").setValue("allowed");
        }
        for (int c = 0 ; c<third.length-1; c++){
            mUsers.child(third[c]).child("permission").setValue("allowed");
        }
        for (int d = 0 ; d<fourth.length-1; d++){
            mUsers.child(fourth[d]).child("permission").setValue("allowed");
        }
        for (int e = 0 ; e<fifth.length-1; e++){
            mUsers.child(fifth[e]).child("permission").setValue("allowed");
        }
    }

    private void closeVote() {
        for (int a = 0 ; a<first.length-1; a++){
            mUsers.child(first[a]).child("permission").setValue("not_allowed");
        }
        for (int b = 0 ; b<sec.length-1; b++){
            mUsers.child(sec[b]).child("permission").setValue("not_allowed");
        }
        for (int c = 0 ; c<third.length-1; c++){
            mUsers.child(third[c]).child("permission").setValue("not_allowed");
        }
        for (int d = 0 ; d<fourth.length-1; d++){
            mUsers.child(fourth[d]).child("permission").setValue("not_allowed");
        }
        for (int e = 0 ; e<fifth.length-1; e++){
            mUsers.child(fifth[e]).child("permission").setValue("not_allowed");
        }
    }
}
