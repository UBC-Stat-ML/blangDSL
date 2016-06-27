package ca.ubc.stat.blang.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ca.ubc.stat.blang.services.BlangDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBlangDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'model'", "'{'", "'}'", "'random'", "'param'", "'const'", "'='", "'laws'", "'indicator'", "'('", "','", "')'", "'logf'", "'|'", "'~'", "'+='", "'-='", "'*='", "'/='", "'%='", "'<'", "'>'", "'>='", "'||'", "'&&'", "'=='", "'!='", "'==='", "'!=='", "'instanceof'", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'/'", "'%'", "'!'", "'as'", "'++'", "'--'", "'.'", "'::'", "'?.'", "'#'", "'['", "']'", "';'", "'if'", "'else'", "'switch'", "':'", "'default'", "'case'", "'for'", "'while'", "'do'", "'var'", "'val'", "'extends'", "'static'", "'import'", "'extension'", "'super'", "'new'", "'false'", "'true'", "'null'", "'typeof'", "'throw'", "'return'", "'try'", "'finally'", "'synchronized'", "'catch'", "'?'", "'&'"
    };
    public static final int RULE_HEX=5;
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=8;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int RULE_DECIMAL=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalBlangDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBlangDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBlangDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBlangDsl.g"; }



     	private BlangDslGrammarAccess grammarAccess;

        public InternalBlangDslParser(TokenStream input, BlangDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "BlangModel";
       	}

       	@Override
       	protected BlangDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleBlangModel"
    // InternalBlangDsl.g:64:1: entryRuleBlangModel returns [EObject current=null] : iv_ruleBlangModel= ruleBlangModel EOF ;
    public final EObject entryRuleBlangModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlangModel = null;


        try {
            // InternalBlangDsl.g:64:51: (iv_ruleBlangModel= ruleBlangModel EOF )
            // InternalBlangDsl.g:65:2: iv_ruleBlangModel= ruleBlangModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlangModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlangModel=ruleBlangModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlangModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlangModel"


    // $ANTLR start "ruleBlangModel"
    // InternalBlangDsl.g:71:1: ruleBlangModel returns [EObject current=null] : ( () (otherlv_1= 'package' ( (lv_name_2_0= ruleQualifiedName ) ) )? ( (lv_importSection_3_0= ruleXImportSection ) )? (otherlv_4= 'model' otherlv_5= '{' ( (lv_vars_6_0= ruleVars ) ) ( (lv_laws_7_0= ruleLaws ) )? otherlv_8= '}' )? ) ;
    public final EObject ruleBlangModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_importSection_3_0 = null;

        EObject lv_vars_6_0 = null;

        EObject lv_laws_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:77:2: ( ( () (otherlv_1= 'package' ( (lv_name_2_0= ruleQualifiedName ) ) )? ( (lv_importSection_3_0= ruleXImportSection ) )? (otherlv_4= 'model' otherlv_5= '{' ( (lv_vars_6_0= ruleVars ) ) ( (lv_laws_7_0= ruleLaws ) )? otherlv_8= '}' )? ) )
            // InternalBlangDsl.g:78:2: ( () (otherlv_1= 'package' ( (lv_name_2_0= ruleQualifiedName ) ) )? ( (lv_importSection_3_0= ruleXImportSection ) )? (otherlv_4= 'model' otherlv_5= '{' ( (lv_vars_6_0= ruleVars ) ) ( (lv_laws_7_0= ruleLaws ) )? otherlv_8= '}' )? )
            {
            // InternalBlangDsl.g:78:2: ( () (otherlv_1= 'package' ( (lv_name_2_0= ruleQualifiedName ) ) )? ( (lv_importSection_3_0= ruleXImportSection ) )? (otherlv_4= 'model' otherlv_5= '{' ( (lv_vars_6_0= ruleVars ) ) ( (lv_laws_7_0= ruleLaws ) )? otherlv_8= '}' )? )
            // InternalBlangDsl.g:79:3: () (otherlv_1= 'package' ( (lv_name_2_0= ruleQualifiedName ) ) )? ( (lv_importSection_3_0= ruleXImportSection ) )? (otherlv_4= 'model' otherlv_5= '{' ( (lv_vars_6_0= ruleVars ) ) ( (lv_laws_7_0= ruleLaws ) )? otherlv_8= '}' )?
            {
            // InternalBlangDsl.g:79:3: ()
            // InternalBlangDsl.g:80:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlangModelAccess().getBlangModelAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:86:3: (otherlv_1= 'package' ( (lv_name_2_0= ruleQualifiedName ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalBlangDsl.g:87:4: otherlv_1= 'package' ( (lv_name_2_0= ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getBlangModelAccess().getPackageKeyword_1_0());
                      			
                    }
                    // InternalBlangDsl.g:91:4: ( (lv_name_2_0= ruleQualifiedName ) )
                    // InternalBlangDsl.g:92:5: (lv_name_2_0= ruleQualifiedName )
                    {
                    // InternalBlangDsl.g:92:5: (lv_name_2_0= ruleQualifiedName )
                    // InternalBlangDsl.g:93:6: lv_name_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBlangModelAccess().getNameQualifiedNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_name_2_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBlangModelRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"org.eclipse.xtext.xbase.Xbase.QualifiedName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBlangDsl.g:111:3: ( (lv_importSection_3_0= ruleXImportSection ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==80) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBlangDsl.g:112:4: (lv_importSection_3_0= ruleXImportSection )
                    {
                    // InternalBlangDsl.g:112:4: (lv_importSection_3_0= ruleXImportSection )
                    // InternalBlangDsl.g:113:5: lv_importSection_3_0= ruleXImportSection
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBlangModelAccess().getImportSectionXImportSectionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_importSection_3_0=ruleXImportSection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBlangModelRule());
                      					}
                      					set(
                      						current,
                      						"importSection",
                      						lv_importSection_3_0,
                      						"org.eclipse.xtext.xbase.Xtype.XImportSection");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBlangDsl.g:130:3: (otherlv_4= 'model' otherlv_5= '{' ( (lv_vars_6_0= ruleVars ) ) ( (lv_laws_7_0= ruleLaws ) )? otherlv_8= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBlangDsl.g:131:4: otherlv_4= 'model' otherlv_5= '{' ( (lv_vars_6_0= ruleVars ) ) ( (lv_laws_7_0= ruleLaws ) )? otherlv_8= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBlangModelAccess().getModelKeyword_3_0());
                      			
                    }
                    otherlv_5=(Token)match(input,15,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getBlangModelAccess().getLeftCurlyBracketKeyword_3_1());
                      			
                    }
                    // InternalBlangDsl.g:139:4: ( (lv_vars_6_0= ruleVars ) )
                    // InternalBlangDsl.g:140:5: (lv_vars_6_0= ruleVars )
                    {
                    // InternalBlangDsl.g:140:5: (lv_vars_6_0= ruleVars )
                    // InternalBlangDsl.g:141:6: lv_vars_6_0= ruleVars
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBlangModelAccess().getVarsVarsParserRuleCall_3_2_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
                    lv_vars_6_0=ruleVars();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBlangModelRule());
                      						}
                      						set(
                      							current,
                      							"vars",
                      							lv_vars_6_0,
                      							"ca.ubc.stat.blang.BlangDsl.Vars");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:158:4: ( (lv_laws_7_0= ruleLaws ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==21) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalBlangDsl.g:159:5: (lv_laws_7_0= ruleLaws )
                            {
                            // InternalBlangDsl.g:159:5: (lv_laws_7_0= ruleLaws )
                            // InternalBlangDsl.g:160:6: lv_laws_7_0= ruleLaws
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getBlangModelAccess().getLawsLawsParserRuleCall_3_3_0());
                              					
                            }
                            pushFollow(FOLLOW_9);
                            lv_laws_7_0=ruleLaws();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getBlangModelRule());
                              						}
                              						set(
                              							current,
                              							"laws",
                              							lv_laws_7_0,
                              							"ca.ubc.stat.blang.BlangDsl.Laws");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getBlangModelAccess().getRightCurlyBracketKeyword_3_4());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlangModel"


    // $ANTLR start "entryRuleVars"
    // InternalBlangDsl.g:186:1: entryRuleVars returns [EObject current=null] : iv_ruleVars= ruleVars EOF ;
    public final EObject entryRuleVars() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVars = null;


        try {
            // InternalBlangDsl.g:186:45: (iv_ruleVars= ruleVars EOF )
            // InternalBlangDsl.g:187:2: iv_ruleVars= ruleVars EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVars=ruleVars();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVars; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVars"


    // $ANTLR start "ruleVars"
    // InternalBlangDsl.g:193:1: ruleVars returns [EObject current=null] : ( () ( ( (lv_randomVars_1_0= ruleRandom ) ) | ( (lv_paramVars_2_0= ruleParamVar ) ) | ( (lv_consts_3_0= ruleConst ) ) )* ) ;
    public final EObject ruleVars() throws RecognitionException {
        EObject current = null;

        EObject lv_randomVars_1_0 = null;

        EObject lv_paramVars_2_0 = null;

        EObject lv_consts_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:199:2: ( ( () ( ( (lv_randomVars_1_0= ruleRandom ) ) | ( (lv_paramVars_2_0= ruleParamVar ) ) | ( (lv_consts_3_0= ruleConst ) ) )* ) )
            // InternalBlangDsl.g:200:2: ( () ( ( (lv_randomVars_1_0= ruleRandom ) ) | ( (lv_paramVars_2_0= ruleParamVar ) ) | ( (lv_consts_3_0= ruleConst ) ) )* )
            {
            // InternalBlangDsl.g:200:2: ( () ( ( (lv_randomVars_1_0= ruleRandom ) ) | ( (lv_paramVars_2_0= ruleParamVar ) ) | ( (lv_consts_3_0= ruleConst ) ) )* )
            // InternalBlangDsl.g:201:3: () ( ( (lv_randomVars_1_0= ruleRandom ) ) | ( (lv_paramVars_2_0= ruleParamVar ) ) | ( (lv_consts_3_0= ruleConst ) ) )*
            {
            // InternalBlangDsl.g:201:3: ()
            // InternalBlangDsl.g:202:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarsAccess().getVarsAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:208:3: ( ( (lv_randomVars_1_0= ruleRandom ) ) | ( (lv_paramVars_2_0= ruleParamVar ) ) | ( (lv_consts_3_0= ruleConst ) ) )*
            loop5:
            do {
                int alt5=4;
                switch ( input.LA(1) ) {
                case 17:
                    {
                    alt5=1;
                    }
                    break;
                case 18:
                    {
                    alt5=2;
                    }
                    break;
                case 19:
                    {
                    alt5=3;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // InternalBlangDsl.g:209:4: ( (lv_randomVars_1_0= ruleRandom ) )
            	    {
            	    // InternalBlangDsl.g:209:4: ( (lv_randomVars_1_0= ruleRandom ) )
            	    // InternalBlangDsl.g:210:5: (lv_randomVars_1_0= ruleRandom )
            	    {
            	    // InternalBlangDsl.g:210:5: (lv_randomVars_1_0= ruleRandom )
            	    // InternalBlangDsl.g:211:6: lv_randomVars_1_0= ruleRandom
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVarsAccess().getRandomVarsRandomParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_randomVars_1_0=ruleRandom();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getVarsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"randomVars",
            	      							lv_randomVars_1_0,
            	      							"ca.ubc.stat.blang.BlangDsl.Random");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBlangDsl.g:229:4: ( (lv_paramVars_2_0= ruleParamVar ) )
            	    {
            	    // InternalBlangDsl.g:229:4: ( (lv_paramVars_2_0= ruleParamVar ) )
            	    // InternalBlangDsl.g:230:5: (lv_paramVars_2_0= ruleParamVar )
            	    {
            	    // InternalBlangDsl.g:230:5: (lv_paramVars_2_0= ruleParamVar )
            	    // InternalBlangDsl.g:231:6: lv_paramVars_2_0= ruleParamVar
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVarsAccess().getParamVarsParamVarParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_paramVars_2_0=ruleParamVar();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getVarsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"paramVars",
            	      							lv_paramVars_2_0,
            	      							"ca.ubc.stat.blang.BlangDsl.ParamVar");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalBlangDsl.g:249:4: ( (lv_consts_3_0= ruleConst ) )
            	    {
            	    // InternalBlangDsl.g:249:4: ( (lv_consts_3_0= ruleConst ) )
            	    // InternalBlangDsl.g:250:5: (lv_consts_3_0= ruleConst )
            	    {
            	    // InternalBlangDsl.g:250:5: (lv_consts_3_0= ruleConst )
            	    // InternalBlangDsl.g:251:6: lv_consts_3_0= ruleConst
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVarsAccess().getConstsConstParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_consts_3_0=ruleConst();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getVarsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"consts",
            	      							lv_consts_3_0,
            	      							"ca.ubc.stat.blang.BlangDsl.Const");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVars"


    // $ANTLR start "entryRuleRandom"
    // InternalBlangDsl.g:273:1: entryRuleRandom returns [EObject current=null] : iv_ruleRandom= ruleRandom EOF ;
    public final EObject entryRuleRandom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandom = null;


        try {
            // InternalBlangDsl.g:273:47: (iv_ruleRandom= ruleRandom EOF )
            // InternalBlangDsl.g:274:2: iv_ruleRandom= ruleRandom EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRandomRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRandom=ruleRandom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRandom; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandom"


    // $ANTLR start "ruleRandom"
    // InternalBlangDsl.g:280:1: ruleRandom returns [EObject current=null] : (otherlv_0= 'random' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) ) ;
    public final EObject ruleRandom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:286:2: ( (otherlv_0= 'random' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) ) )
            // InternalBlangDsl.g:287:2: (otherlv_0= 'random' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) )
            {
            // InternalBlangDsl.g:287:2: (otherlv_0= 'random' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) )
            // InternalBlangDsl.g:288:3: otherlv_0= 'random' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRandomAccess().getRandomKeyword_0());
              		
            }
            // InternalBlangDsl.g:292:3: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:293:4: (lv_type_1_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:293:4: (lv_type_1_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:294:5: lv_type_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRandomAccess().getTypeJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRandomRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:311:3: ( (lv_name_2_0= ruleValidID ) )
            // InternalBlangDsl.g:312:4: (lv_name_2_0= ruleValidID )
            {
            // InternalBlangDsl.g:312:4: (lv_name_2_0= ruleValidID )
            // InternalBlangDsl.g:313:5: lv_name_2_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRandomAccess().getNameValidIDParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_2_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRandomRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandom"


    // $ANTLR start "entryRuleParamVar"
    // InternalBlangDsl.g:334:1: entryRuleParamVar returns [EObject current=null] : iv_ruleParamVar= ruleParamVar EOF ;
    public final EObject entryRuleParamVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamVar = null;


        try {
            // InternalBlangDsl.g:334:49: (iv_ruleParamVar= ruleParamVar EOF )
            // InternalBlangDsl.g:335:2: iv_ruleParamVar= ruleParamVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamVarRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParamVar=ruleParamVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamVar; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParamVar"


    // $ANTLR start "ruleParamVar"
    // InternalBlangDsl.g:341:1: ruleParamVar returns [EObject current=null] : (otherlv_0= 'param' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) ) ;
    public final EObject ruleParamVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:347:2: ( (otherlv_0= 'param' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) ) )
            // InternalBlangDsl.g:348:2: (otherlv_0= 'param' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) )
            {
            // InternalBlangDsl.g:348:2: (otherlv_0= 'param' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) )
            // InternalBlangDsl.g:349:3: otherlv_0= 'param' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParamVarAccess().getParamKeyword_0());
              		
            }
            // InternalBlangDsl.g:353:3: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:354:4: (lv_type_1_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:354:4: (lv_type_1_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:355:5: lv_type_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParamVarAccess().getTypeJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParamVarRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:372:3: ( (lv_name_2_0= ruleValidID ) )
            // InternalBlangDsl.g:373:4: (lv_name_2_0= ruleValidID )
            {
            // InternalBlangDsl.g:373:4: (lv_name_2_0= ruleValidID )
            // InternalBlangDsl.g:374:5: lv_name_2_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParamVarAccess().getNameValidIDParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_2_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParamVarRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParamVar"


    // $ANTLR start "entryRuleConst"
    // InternalBlangDsl.g:395:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalBlangDsl.g:395:46: (iv_ruleConst= ruleConst EOF )
            // InternalBlangDsl.g:396:2: iv_ruleConst= ruleConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConst=ruleConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConst; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConst"


    // $ANTLR start "ruleConst"
    // InternalBlangDsl.g:402:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_right_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:408:2: ( (otherlv_0= 'const' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_right_4_0= ruleXExpression ) ) ) )
            // InternalBlangDsl.g:409:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_right_4_0= ruleXExpression ) ) )
            {
            // InternalBlangDsl.g:409:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_right_4_0= ruleXExpression ) ) )
            // InternalBlangDsl.g:410:3: otherlv_0= 'const' ( (lv_type_1_0= ruleJvmTypeReference ) ) ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_right_4_0= ruleXExpression ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalBlangDsl.g:414:3: ( (lv_type_1_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:415:4: (lv_type_1_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:415:4: (lv_type_1_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:416:5: lv_type_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getTypeJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:433:3: ( (lv_name_2_0= ruleValidID ) )
            // InternalBlangDsl.g:434:4: (lv_name_2_0= ruleValidID )
            {
            // InternalBlangDsl.g:434:4: (lv_name_2_0= ruleValidID )
            // InternalBlangDsl.g:435:5: lv_name_2_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getNameValidIDParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_name_2_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstAccess().getEqualsSignKeyword_3());
              		
            }
            // InternalBlangDsl.g:456:3: ( (lv_right_4_0= ruleXExpression ) )
            // InternalBlangDsl.g:457:4: (lv_right_4_0= ruleXExpression )
            {
            // InternalBlangDsl.g:457:4: (lv_right_4_0= ruleXExpression )
            // InternalBlangDsl.g:458:5: lv_right_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getRightXExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_right_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"right",
              						lv_right_4_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConst"


    // $ANTLR start "entryRuleLaws"
    // InternalBlangDsl.g:479:1: entryRuleLaws returns [EObject current=null] : iv_ruleLaws= ruleLaws EOF ;
    public final EObject entryRuleLaws() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLaws = null;


        try {
            // InternalBlangDsl.g:479:45: (iv_ruleLaws= ruleLaws EOF )
            // InternalBlangDsl.g:480:2: iv_ruleLaws= ruleLaws EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLawsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLaws=ruleLaws();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLaws; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLaws"


    // $ANTLR start "ruleLaws"
    // InternalBlangDsl.g:486:1: ruleLaws returns [EObject current=null] : ( () otherlv_1= 'laws' otherlv_2= '{' ( (lv_modelComponents_3_0= ruleModelComponent ) )* otherlv_4= '}' ) ;
    public final EObject ruleLaws() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_modelComponents_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:492:2: ( ( () otherlv_1= 'laws' otherlv_2= '{' ( (lv_modelComponents_3_0= ruleModelComponent ) )* otherlv_4= '}' ) )
            // InternalBlangDsl.g:493:2: ( () otherlv_1= 'laws' otherlv_2= '{' ( (lv_modelComponents_3_0= ruleModelComponent ) )* otherlv_4= '}' )
            {
            // InternalBlangDsl.g:493:2: ( () otherlv_1= 'laws' otherlv_2= '{' ( (lv_modelComponents_3_0= ruleModelComponent ) )* otherlv_4= '}' )
            // InternalBlangDsl.g:494:3: () otherlv_1= 'laws' otherlv_2= '{' ( (lv_modelComponents_3_0= ruleModelComponent ) )* otherlv_4= '}'
            {
            // InternalBlangDsl.g:494:3: ()
            // InternalBlangDsl.g:495:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLawsAccess().getLawsAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLawsAccess().getLawsKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,15,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLawsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalBlangDsl.g:509:3: ( (lv_modelComponents_3_0= ruleModelComponent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||LA6_0==22||LA6_0==26) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBlangDsl.g:510:4: (lv_modelComponents_3_0= ruleModelComponent )
            	    {
            	    // InternalBlangDsl.g:510:4: (lv_modelComponents_3_0= ruleModelComponent )
            	    // InternalBlangDsl.g:511:5: lv_modelComponents_3_0= ruleModelComponent
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLawsAccess().getModelComponentsModelComponentParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_modelComponents_3_0=ruleModelComponent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getLawsRule());
            	      					}
            	      					add(
            	      						current,
            	      						"modelComponents",
            	      						lv_modelComponents_3_0,
            	      						"ca.ubc.stat.blang.BlangDsl.ModelComponent");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLawsAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLaws"


    // $ANTLR start "entryRuleModelComponent"
    // InternalBlangDsl.g:536:1: entryRuleModelComponent returns [EObject current=null] : iv_ruleModelComponent= ruleModelComponent EOF ;
    public final EObject entryRuleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelComponent = null;


        try {
            // InternalBlangDsl.g:536:55: (iv_ruleModelComponent= ruleModelComponent EOF )
            // InternalBlangDsl.g:537:2: iv_ruleModelComponent= ruleModelComponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelComponentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModelComponent=ruleModelComponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelComponent; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelComponent"


    // $ANTLR start "ruleModelComponent"
    // InternalBlangDsl.g:543:1: ruleModelComponent returns [EObject current=null] : (this_SupportFactor_0= ruleSupportFactor | this_LogScaleFactor_1= ruleLogScaleFactor | this_ModelParam_2= ruleModelParam ) ;
    public final EObject ruleModelComponent() throws RecognitionException {
        EObject current = null;

        EObject this_SupportFactor_0 = null;

        EObject this_LogScaleFactor_1 = null;

        EObject this_ModelParam_2 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:549:2: ( (this_SupportFactor_0= ruleSupportFactor | this_LogScaleFactor_1= ruleLogScaleFactor | this_ModelParam_2= ruleModelParam ) )
            // InternalBlangDsl.g:550:2: (this_SupportFactor_0= ruleSupportFactor | this_LogScaleFactor_1= ruleLogScaleFactor | this_ModelParam_2= ruleModelParam )
            {
            // InternalBlangDsl.g:550:2: (this_SupportFactor_0= ruleSupportFactor | this_LogScaleFactor_1= ruleLogScaleFactor | this_ModelParam_2= ruleModelParam )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt7=1;
                }
                break;
            case 26:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalBlangDsl.g:551:3: this_SupportFactor_0= ruleSupportFactor
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getModelComponentAccess().getSupportFactorParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SupportFactor_0=ruleSupportFactor();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SupportFactor_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:560:3: this_LogScaleFactor_1= ruleLogScaleFactor
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getModelComponentAccess().getLogScaleFactorParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LogScaleFactor_1=ruleLogScaleFactor();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LogScaleFactor_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:569:3: this_ModelParam_2= ruleModelParam
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getModelComponentAccess().getModelParamParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ModelParam_2=ruleModelParam();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ModelParam_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelComponent"


    // $ANTLR start "entryRuleSupportFactor"
    // InternalBlangDsl.g:581:1: entryRuleSupportFactor returns [EObject current=null] : iv_ruleSupportFactor= ruleSupportFactor EOF ;
    public final EObject entryRuleSupportFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSupportFactor = null;


        try {
            // InternalBlangDsl.g:581:54: (iv_ruleSupportFactor= ruleSupportFactor EOF )
            // InternalBlangDsl.g:582:2: iv_ruleSupportFactor= ruleSupportFactor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSupportFactorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSupportFactor=ruleSupportFactor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSupportFactor; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSupportFactor"


    // $ANTLR start "ruleSupportFactor"
    // InternalBlangDsl.g:588:1: ruleSupportFactor returns [EObject current=null] : (otherlv_0= 'indicator' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) ) ) ;
    public final EObject ruleSupportFactor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_params_2_0 = null;

        AntlrDatatypeRuleToken lv_params_4_0 = null;

        EObject lv_expr_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:594:2: ( (otherlv_0= 'indicator' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) ) ) )
            // InternalBlangDsl.g:595:2: (otherlv_0= 'indicator' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) ) )
            {
            // InternalBlangDsl.g:595:2: (otherlv_0= 'indicator' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) ) )
            // InternalBlangDsl.g:596:3: otherlv_0= 'indicator' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSupportFactorAccess().getIndicatorKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,23,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSupportFactorAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBlangDsl.g:604:3: ( (lv_params_2_0= ruleValidID ) )
            // InternalBlangDsl.g:605:4: (lv_params_2_0= ruleValidID )
            {
            // InternalBlangDsl.g:605:4: (lv_params_2_0= ruleValidID )
            // InternalBlangDsl.g:606:5: lv_params_2_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSupportFactorAccess().getParamsValidIDParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_params_2_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSupportFactorRule());
              					}
              					add(
              						current,
              						"params",
              						lv_params_2_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:623:3: (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBlangDsl.g:624:4: otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) )
            	    {
            	    otherlv_3=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getSupportFactorAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalBlangDsl.g:628:4: ( (lv_params_4_0= ruleValidID ) )
            	    // InternalBlangDsl.g:629:5: (lv_params_4_0= ruleValidID )
            	    {
            	    // InternalBlangDsl.g:629:5: (lv_params_4_0= ruleValidID )
            	    // InternalBlangDsl.g:630:6: lv_params_4_0= ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSupportFactorAccess().getParamsValidIDParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_params_4_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSupportFactorRule());
            	      						}
            	      						add(
            	      							current,
            	      							"params",
            	      							lv_params_4_0,
            	      							"org.eclipse.xtext.xbase.Xtype.ValidID");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getSupportFactorAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_6=(Token)match(input,20,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSupportFactorAccess().getEqualsSignKeyword_5());
              		
            }
            // InternalBlangDsl.g:656:3: ( (lv_expr_7_0= ruleXBlockExpression ) )
            // InternalBlangDsl.g:657:4: (lv_expr_7_0= ruleXBlockExpression )
            {
            // InternalBlangDsl.g:657:4: (lv_expr_7_0= ruleXBlockExpression )
            // InternalBlangDsl.g:658:5: lv_expr_7_0= ruleXBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSupportFactorAccess().getExprXBlockExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_7_0=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSupportFactorRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_7_0,
              						"org.eclipse.xtext.xbase.Xbase.XBlockExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSupportFactor"


    // $ANTLR start "entryRuleLogScaleFactor"
    // InternalBlangDsl.g:679:1: entryRuleLogScaleFactor returns [EObject current=null] : iv_ruleLogScaleFactor= ruleLogScaleFactor EOF ;
    public final EObject entryRuleLogScaleFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogScaleFactor = null;


        try {
            // InternalBlangDsl.g:679:55: (iv_ruleLogScaleFactor= ruleLogScaleFactor EOF )
            // InternalBlangDsl.g:680:2: iv_ruleLogScaleFactor= ruleLogScaleFactor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogScaleFactorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogScaleFactor=ruleLogScaleFactor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogScaleFactor; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogScaleFactor"


    // $ANTLR start "ruleLogScaleFactor"
    // InternalBlangDsl.g:686:1: ruleLogScaleFactor returns [EObject current=null] : (otherlv_0= 'logf' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) ) ) ;
    public final EObject ruleLogScaleFactor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_params_2_0 = null;

        AntlrDatatypeRuleToken lv_params_4_0 = null;

        EObject lv_expr_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:692:2: ( (otherlv_0= 'logf' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) ) ) )
            // InternalBlangDsl.g:693:2: (otherlv_0= 'logf' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) ) )
            {
            // InternalBlangDsl.g:693:2: (otherlv_0= 'logf' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) ) )
            // InternalBlangDsl.g:694:3: otherlv_0= 'logf' otherlv_1= '(' ( (lv_params_2_0= ruleValidID ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )* otherlv_5= ')' otherlv_6= '=' ( (lv_expr_7_0= ruleXBlockExpression ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLogScaleFactorAccess().getLogfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,23,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLogScaleFactorAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBlangDsl.g:702:3: ( (lv_params_2_0= ruleValidID ) )
            // InternalBlangDsl.g:703:4: (lv_params_2_0= ruleValidID )
            {
            // InternalBlangDsl.g:703:4: (lv_params_2_0= ruleValidID )
            // InternalBlangDsl.g:704:5: lv_params_2_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogScaleFactorAccess().getParamsValidIDParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_params_2_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLogScaleFactorRule());
              					}
              					add(
              						current,
              						"params",
              						lv_params_2_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:721:3: (otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBlangDsl.g:722:4: otherlv_3= ',' ( (lv_params_4_0= ruleValidID ) )
            	    {
            	    otherlv_3=(Token)match(input,24,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getLogScaleFactorAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalBlangDsl.g:726:4: ( (lv_params_4_0= ruleValidID ) )
            	    // InternalBlangDsl.g:727:5: (lv_params_4_0= ruleValidID )
            	    {
            	    // InternalBlangDsl.g:727:5: (lv_params_4_0= ruleValidID )
            	    // InternalBlangDsl.g:728:6: lv_params_4_0= ruleValidID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogScaleFactorAccess().getParamsValidIDParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_params_4_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogScaleFactorRule());
            	      						}
            	      						add(
            	      							current,
            	      							"params",
            	      							lv_params_4_0,
            	      							"org.eclipse.xtext.xbase.Xtype.ValidID");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getLogScaleFactorAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_6=(Token)match(input,20,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getLogScaleFactorAccess().getEqualsSignKeyword_5());
              		
            }
            // InternalBlangDsl.g:754:3: ( (lv_expr_7_0= ruleXBlockExpression ) )
            // InternalBlangDsl.g:755:4: (lv_expr_7_0= ruleXBlockExpression )
            {
            // InternalBlangDsl.g:755:4: (lv_expr_7_0= ruleXBlockExpression )
            // InternalBlangDsl.g:756:5: lv_expr_7_0= ruleXBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogScaleFactorAccess().getExprXBlockExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_7_0=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLogScaleFactorRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_7_0,
              						"org.eclipse.xtext.xbase.Xbase.XBlockExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogScaleFactor"


    // $ANTLR start "entryRuleModelParam"
    // InternalBlangDsl.g:777:1: entryRuleModelParam returns [EObject current=null] : iv_ruleModelParam= ruleModelParam EOF ;
    public final EObject entryRuleModelParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelParam = null;


        try {
            // InternalBlangDsl.g:777:51: (iv_ruleModelParam= ruleModelParam EOF )
            // InternalBlangDsl.g:778:2: iv_ruleModelParam= ruleModelParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelParamRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModelParam=ruleModelParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelParam; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelParam"


    // $ANTLR start "ruleModelParam"
    // InternalBlangDsl.g:784:1: ruleModelParam returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= '|' ( (lv_deps_2_0= ruleDependency ) )+ otherlv_3= '~' ( (lv_right_4_0= ruleDistribution ) ) ) ;
    public final EObject ruleModelParam() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_deps_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:790:2: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= '|' ( (lv_deps_2_0= ruleDependency ) )+ otherlv_3= '~' ( (lv_right_4_0= ruleDistribution ) ) ) )
            // InternalBlangDsl.g:791:2: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= '|' ( (lv_deps_2_0= ruleDependency ) )+ otherlv_3= '~' ( (lv_right_4_0= ruleDistribution ) ) )
            {
            // InternalBlangDsl.g:791:2: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= '|' ( (lv_deps_2_0= ruleDependency ) )+ otherlv_3= '~' ( (lv_right_4_0= ruleDistribution ) ) )
            // InternalBlangDsl.g:792:3: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= '|' ( (lv_deps_2_0= ruleDependency ) )+ otherlv_3= '~' ( (lv_right_4_0= ruleDistribution ) )
            {
            // InternalBlangDsl.g:792:3: ( (lv_name_0_0= ruleValidID ) )
            // InternalBlangDsl.g:793:4: (lv_name_0_0= ruleValidID )
            {
            // InternalBlangDsl.g:793:4: (lv_name_0_0= ruleValidID )
            // InternalBlangDsl.g:794:5: lv_name_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModelParamAccess().getNameValidIDParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_name_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModelParamRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getModelParamAccess().getVerticalLineKeyword_1());
              		
            }
            // InternalBlangDsl.g:815:3: ( (lv_deps_2_0= ruleDependency ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||LA10_0==23||LA10_0==47) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalBlangDsl.g:816:4: (lv_deps_2_0= ruleDependency )
            	    {
            	    // InternalBlangDsl.g:816:4: (lv_deps_2_0= ruleDependency )
            	    // InternalBlangDsl.g:817:5: lv_deps_2_0= ruleDependency
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getModelParamAccess().getDepsDependencyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_18);
            	    lv_deps_2_0=ruleDependency();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getModelParamRule());
            	      					}
            	      					add(
            	      						current,
            	      						"deps",
            	      						lv_deps_2_0,
            	      						"ca.ubc.stat.blang.BlangDsl.Dependency");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getModelParamAccess().getTildeKeyword_3());
              		
            }
            // InternalBlangDsl.g:838:3: ( (lv_right_4_0= ruleDistribution ) )
            // InternalBlangDsl.g:839:4: (lv_right_4_0= ruleDistribution )
            {
            // InternalBlangDsl.g:839:4: (lv_right_4_0= ruleDistribution )
            // InternalBlangDsl.g:840:5: lv_right_4_0= ruleDistribution
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModelParamAccess().getRightDistributionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_right_4_0=ruleDistribution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModelParamRule());
              					}
              					set(
              						current,
              						"right",
              						lv_right_4_0,
              						"ca.ubc.stat.blang.BlangDsl.Distribution");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelParam"


    // $ANTLR start "entryRuleDependency"
    // InternalBlangDsl.g:861:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalBlangDsl.g:861:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalBlangDsl.g:862:2: iv_ruleDependency= ruleDependency EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDependencyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDependency=ruleDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDependency; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDependency"


    // $ANTLR start "ruleDependency"
    // InternalBlangDsl.g:868:1: ruleDependency returns [EObject current=null] : ( ( (lv_type_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '=' ( (lv_init_3_0= ruleValidID ) ) ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_init_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:874:2: ( ( ( (lv_type_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '=' ( (lv_init_3_0= ruleValidID ) ) ) )
            // InternalBlangDsl.g:875:2: ( ( (lv_type_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '=' ( (lv_init_3_0= ruleValidID ) ) )
            {
            // InternalBlangDsl.g:875:2: ( ( (lv_type_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '=' ( (lv_init_3_0= ruleValidID ) ) )
            // InternalBlangDsl.g:876:3: ( (lv_type_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '=' ( (lv_init_3_0= ruleValidID ) )
            {
            // InternalBlangDsl.g:876:3: ( (lv_type_0_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:877:4: (lv_type_0_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:877:4: (lv_type_0_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:878:5: lv_type_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDependencyAccess().getTypeJvmTypeReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDependencyRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:895:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalBlangDsl.g:896:4: (lv_name_1_0= ruleValidID )
            {
            // InternalBlangDsl.g:896:4: (lv_name_1_0= ruleValidID )
            // InternalBlangDsl.g:897:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDependencyAccess().getNameValidIDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDependencyRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDependencyAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalBlangDsl.g:918:3: ( (lv_init_3_0= ruleValidID ) )
            // InternalBlangDsl.g:919:4: (lv_init_3_0= ruleValidID )
            {
            // InternalBlangDsl.g:919:4: (lv_init_3_0= ruleValidID )
            // InternalBlangDsl.g:920:5: lv_init_3_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDependencyAccess().getInitValidIDParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_init_3_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDependencyRule());
              					}
              					set(
              						current,
              						"init",
              						lv_init_3_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependency"


    // $ANTLR start "entryRuleDistribution"
    // InternalBlangDsl.g:941:1: entryRuleDistribution returns [EObject current=null] : iv_ruleDistribution= ruleDistribution EOF ;
    public final EObject entryRuleDistribution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDistribution = null;


        try {
            // InternalBlangDsl.g:941:53: (iv_ruleDistribution= ruleDistribution EOF )
            // InternalBlangDsl.g:942:2: iv_ruleDistribution= ruleDistribution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDistributionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDistribution=ruleDistribution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDistribution; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDistribution"


    // $ANTLR start "ruleDistribution"
    // InternalBlangDsl.g:948:1: ruleDistribution returns [EObject current=null] : ( ( (lv_clazz_0_0= ruleJvmTypeReference ) ) otherlv_1= '(' ( (lv_param_2_0= ruleParam ) ) (otherlv_3= ',' ( (lv_param_4_0= ruleParam ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleDistribution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_clazz_0_0 = null;

        EObject lv_param_2_0 = null;

        EObject lv_param_4_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:954:2: ( ( ( (lv_clazz_0_0= ruleJvmTypeReference ) ) otherlv_1= '(' ( (lv_param_2_0= ruleParam ) ) (otherlv_3= ',' ( (lv_param_4_0= ruleParam ) ) )* otherlv_5= ')' ) )
            // InternalBlangDsl.g:955:2: ( ( (lv_clazz_0_0= ruleJvmTypeReference ) ) otherlv_1= '(' ( (lv_param_2_0= ruleParam ) ) (otherlv_3= ',' ( (lv_param_4_0= ruleParam ) ) )* otherlv_5= ')' )
            {
            // InternalBlangDsl.g:955:2: ( ( (lv_clazz_0_0= ruleJvmTypeReference ) ) otherlv_1= '(' ( (lv_param_2_0= ruleParam ) ) (otherlv_3= ',' ( (lv_param_4_0= ruleParam ) ) )* otherlv_5= ')' )
            // InternalBlangDsl.g:956:3: ( (lv_clazz_0_0= ruleJvmTypeReference ) ) otherlv_1= '(' ( (lv_param_2_0= ruleParam ) ) (otherlv_3= ',' ( (lv_param_4_0= ruleParam ) ) )* otherlv_5= ')'
            {
            // InternalBlangDsl.g:956:3: ( (lv_clazz_0_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:957:4: (lv_clazz_0_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:957:4: (lv_clazz_0_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:958:5: lv_clazz_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDistributionAccess().getClazzJvmTypeReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_clazz_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDistributionRule());
              					}
              					set(
              						current,
              						"clazz",
              						lv_clazz_0_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDistributionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBlangDsl.g:979:3: ( (lv_param_2_0= ruleParam ) )
            // InternalBlangDsl.g:980:4: (lv_param_2_0= ruleParam )
            {
            // InternalBlangDsl.g:980:4: (lv_param_2_0= ruleParam )
            // InternalBlangDsl.g:981:5: lv_param_2_0= ruleParam
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDistributionAccess().getParamParamParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_param_2_0=ruleParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDistributionRule());
              					}
              					add(
              						current,
              						"param",
              						lv_param_2_0,
              						"ca.ubc.stat.blang.BlangDsl.Param");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:998:3: (otherlv_3= ',' ( (lv_param_4_0= ruleParam ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBlangDsl.g:999:4: otherlv_3= ',' ( (lv_param_4_0= ruleParam ) )
            	    {
            	    otherlv_3=(Token)match(input,24,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getDistributionAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalBlangDsl.g:1003:4: ( (lv_param_4_0= ruleParam ) )
            	    // InternalBlangDsl.g:1004:5: (lv_param_4_0= ruleParam )
            	    {
            	    // InternalBlangDsl.g:1004:5: (lv_param_4_0= ruleParam )
            	    // InternalBlangDsl.g:1005:6: lv_param_4_0= ruleParam
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDistributionAccess().getParamParamParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_param_4_0=ruleParam();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDistributionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"param",
            	      							lv_param_4_0,
            	      							"ca.ubc.stat.blang.BlangDsl.Param");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getDistributionAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDistribution"


    // $ANTLR start "entryRuleParam"
    // InternalBlangDsl.g:1031:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // InternalBlangDsl.g:1031:46: (iv_ruleParam= ruleParam EOF )
            // InternalBlangDsl.g:1032:2: iv_ruleParam= ruleParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParam=ruleParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParam; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // InternalBlangDsl.g:1038:1: ruleParam returns [EObject current=null] : (this_LazyParam_0= ruleLazyParam | this_ConstParam_1= ruleConstParam ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        EObject this_LazyParam_0 = null;

        EObject this_ConstParam_1 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1044:2: ( (this_LazyParam_0= ruleLazyParam | this_ConstParam_1= ruleConstParam ) )
            // InternalBlangDsl.g:1045:2: (this_LazyParam_0= ruleLazyParam | this_ConstParam_1= ruleConstParam )
            {
            // InternalBlangDsl.g:1045:2: (this_LazyParam_0= ruleLazyParam | this_ConstParam_1= ruleConstParam )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==64) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalBlangDsl.g:1046:3: this_LazyParam_0= ruleLazyParam
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParamAccess().getLazyParamParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LazyParam_0=ruleLazyParam();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LazyParam_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:1055:3: this_ConstParam_1= ruleConstParam
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParamAccess().getConstParamParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConstParam_1=ruleConstParam();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstParam_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleConstParam"
    // InternalBlangDsl.g:1067:1: entryRuleConstParam returns [EObject current=null] : iv_ruleConstParam= ruleConstParam EOF ;
    public final EObject entryRuleConstParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstParam = null;


        try {
            // InternalBlangDsl.g:1067:51: (iv_ruleConstParam= ruleConstParam EOF )
            // InternalBlangDsl.g:1068:2: iv_ruleConstParam= ruleConstParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstParamRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstParam=ruleConstParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstParam; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstParam"


    // $ANTLR start "ruleConstParam"
    // InternalBlangDsl.g:1074:1: ruleConstParam returns [EObject current=null] : ( (lv_id_0_0= ruleValidID ) ) ;
    public final EObject ruleConstParam() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_id_0_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1080:2: ( ( (lv_id_0_0= ruleValidID ) ) )
            // InternalBlangDsl.g:1081:2: ( (lv_id_0_0= ruleValidID ) )
            {
            // InternalBlangDsl.g:1081:2: ( (lv_id_0_0= ruleValidID ) )
            // InternalBlangDsl.g:1082:3: (lv_id_0_0= ruleValidID )
            {
            // InternalBlangDsl.g:1082:3: (lv_id_0_0= ruleValidID )
            // InternalBlangDsl.g:1083:4: lv_id_0_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getConstParamAccess().getIdValidIDParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_id_0_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getConstParamRule());
              				}
              				set(
              					current,
              					"id",
              					lv_id_0_0,
              					"org.eclipse.xtext.xbase.Xtype.ValidID");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstParam"


    // $ANTLR start "entryRuleLazyParam"
    // InternalBlangDsl.g:1103:1: entryRuleLazyParam returns [EObject current=null] : iv_ruleLazyParam= ruleLazyParam EOF ;
    public final EObject entryRuleLazyParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLazyParam = null;


        try {
            // InternalBlangDsl.g:1103:50: (iv_ruleLazyParam= ruleLazyParam EOF )
            // InternalBlangDsl.g:1104:2: iv_ruleLazyParam= ruleLazyParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLazyParamRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLazyParam=ruleLazyParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLazyParam; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLazyParam"


    // $ANTLR start "ruleLazyParam"
    // InternalBlangDsl.g:1110:1: ruleLazyParam returns [EObject current=null] : ( ( ( () '[' ) )=> (lv_expr_0_0= ruleXClosure ) ) ;
    public final EObject ruleLazyParam() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1116:2: ( ( ( ( () '[' ) )=> (lv_expr_0_0= ruleXClosure ) ) )
            // InternalBlangDsl.g:1117:2: ( ( ( () '[' ) )=> (lv_expr_0_0= ruleXClosure ) )
            {
            // InternalBlangDsl.g:1117:2: ( ( ( () '[' ) )=> (lv_expr_0_0= ruleXClosure ) )
            // InternalBlangDsl.g:1118:3: ( ( () '[' ) )=> (lv_expr_0_0= ruleXClosure )
            {
            // InternalBlangDsl.g:1124:3: (lv_expr_0_0= ruleXClosure )
            // InternalBlangDsl.g:1125:4: lv_expr_0_0= ruleXClosure
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getLazyParamAccess().getExprXClosureParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_expr_0_0=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getLazyParamRule());
              				}
              				set(
              					current,
              					"expr",
              					lv_expr_0_0,
              					"org.eclipse.xtext.xbase.Xbase.XClosure");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLazyParam"


    // $ANTLR start "entryRuleXExpression"
    // InternalBlangDsl.g:1145:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // InternalBlangDsl.g:1145:52: (iv_ruleXExpression= ruleXExpression EOF )
            // InternalBlangDsl.g:1146:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // InternalBlangDsl.g:1152:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1158:2: (this_XAssignment_0= ruleXAssignment )
            // InternalBlangDsl.g:1159:2: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_XAssignment_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // InternalBlangDsl.g:1170:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // InternalBlangDsl.g:1170:52: (iv_ruleXAssignment= ruleXAssignment EOF )
            // InternalBlangDsl.g:1171:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // InternalBlangDsl.g:1177:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1183:2: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // InternalBlangDsl.g:1184:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // InternalBlangDsl.g:1184:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt14=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==20) ) {
                    alt14=1;
                }
                else if ( (LA14_1==EOF||(LA14_1>=RULE_STRING && LA14_1<=RULE_ID)||(LA14_1>=15 && LA14_1<=19)||LA14_1==21||(LA14_1>=23 && LA14_1<=25)||(LA14_1>=29 && LA14_1<=93)) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case 78:
                {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==20) ) {
                    alt14=1;
                }
                else if ( (LA14_2==EOF||(LA14_2>=RULE_STRING && LA14_2<=RULE_ID)||(LA14_2>=15 && LA14_2<=19)||LA14_2==21||(LA14_2>=23 && LA14_2<=25)||(LA14_2>=29 && LA14_2<=93)) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
                }
                break;
            case 79:
                {
                int LA14_3 = input.LA(2);

                if ( (LA14_3==20) ) {
                    alt14=1;
                }
                else if ( (LA14_3==EOF||(LA14_3>=RULE_STRING && LA14_3<=RULE_ID)||(LA14_3>=15 && LA14_3<=19)||LA14_3==21||(LA14_3>=23 && LA14_3<=25)||(LA14_3>=29 && LA14_3<=93)) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 3, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA14_4 = input.LA(2);

                if ( (LA14_4==20) ) {
                    alt14=1;
                }
                else if ( (LA14_4==EOF||(LA14_4>=RULE_STRING && LA14_4<=RULE_ID)||(LA14_4>=15 && LA14_4<=19)||LA14_4==21||(LA14_4>=23 && LA14_4<=25)||(LA14_4>=29 && LA14_4<=93)) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 4, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA14_5 = input.LA(2);

                if ( (LA14_5==20) ) {
                    alt14=1;
                }
                else if ( (LA14_5==EOF||(LA14_5>=RULE_STRING && LA14_5<=RULE_ID)||(LA14_5>=15 && LA14_5<=19)||LA14_5==21||(LA14_5>=23 && LA14_5<=25)||(LA14_5>=29 && LA14_5<=93)) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 5, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
            case 15:
            case 23:
            case 34:
            case 50:
            case 51:
            case 56:
            case 63:
            case 64:
            case 67:
            case 69:
            case 73:
            case 74:
            case 75:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 92:
                {
                alt14=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalBlangDsl.g:1185:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // InternalBlangDsl.g:1185:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // InternalBlangDsl.g:1186:4: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // InternalBlangDsl.g:1186:4: ()
                    // InternalBlangDsl.g:1187:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalBlangDsl.g:1193:4: ( ( ruleFeatureCallID ) )
                    // InternalBlangDsl.g:1194:5: ( ruleFeatureCallID )
                    {
                    // InternalBlangDsl.g:1194:5: ( ruleFeatureCallID )
                    // InternalBlangDsl.g:1195:6: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXAssignmentRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_13);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalBlangDsl.g:1216:4: ( (lv_value_3_0= ruleXAssignment ) )
                    // InternalBlangDsl.g:1217:5: (lv_value_3_0= ruleXAssignment )
                    {
                    // InternalBlangDsl.g:1217:5: (lv_value_3_0= ruleXAssignment )
                    // InternalBlangDsl.g:1218:6: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XAssignment");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:1237:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // InternalBlangDsl.g:1237:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // InternalBlangDsl.g:1238:4: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_20);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XOrExpression_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalBlangDsl.g:1246:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt13=2;
                    alt13 = dfa13.predict(input);
                    switch (alt13) {
                        case 1 :
                            // InternalBlangDsl.g:1247:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // InternalBlangDsl.g:1247:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // InternalBlangDsl.g:1248:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // InternalBlangDsl.g:1258:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // InternalBlangDsl.g:1259:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // InternalBlangDsl.g:1259:7: ()
                            // InternalBlangDsl.g:1260:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								current = forceCreateModelElementAndSet(
                              									grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                              									current);
                              							
                            }

                            }

                            // InternalBlangDsl.g:1266:7: ( ( ruleOpMultiAssign ) )
                            // InternalBlangDsl.g:1267:8: ( ruleOpMultiAssign )
                            {
                            // InternalBlangDsl.g:1267:8: ( ruleOpMultiAssign )
                            // InternalBlangDsl.g:1268:9: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXAssignmentRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
                              								
                            }
                            pushFollow(FOLLOW_13);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }


                            }

                            // InternalBlangDsl.g:1284:5: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // InternalBlangDsl.g:1285:6: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // InternalBlangDsl.g:1285:6: (lv_rightOperand_7_0= ruleXAssignment )
                            // InternalBlangDsl.g:1286:7: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                              							}
                              							set(
                              								current,
                              								"rightOperand",
                              								lv_rightOperand_7_0,
                              								"org.eclipse.xtext.xbase.Xbase.XAssignment");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // InternalBlangDsl.g:1309:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // InternalBlangDsl.g:1309:54: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // InternalBlangDsl.g:1310:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // InternalBlangDsl.g:1316:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:1322:2: (kw= '=' )
            // InternalBlangDsl.g:1323:2: kw= '='
            {
            kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // InternalBlangDsl.g:1331:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // InternalBlangDsl.g:1331:53: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // InternalBlangDsl.g:1332:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // InternalBlangDsl.g:1338:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:1344:2: ( (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
            // InternalBlangDsl.g:1345:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            {
            // InternalBlangDsl.g:1345:2: (kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
            int alt16=7;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt16=1;
                }
                break;
            case 30:
                {
                alt16=2;
                }
                break;
            case 31:
                {
                alt16=3;
                }
                break;
            case 32:
                {
                alt16=4;
                }
                break;
            case 33:
                {
                alt16=5;
                }
                break;
            case 34:
                {
                alt16=6;
                }
                break;
            case 35:
                {
                alt16=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalBlangDsl.g:1346:3: kw= '+='
                    {
                    kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:1352:3: kw= '-='
                    {
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:1358:3: kw= '*='
                    {
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBlangDsl.g:1364:3: kw= '/='
                    {
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBlangDsl.g:1370:3: kw= '%='
                    {
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBlangDsl.g:1376:3: (kw= '<' kw= '<' kw= '=' )
                    {
                    // InternalBlangDsl.g:1376:3: (kw= '<' kw= '<' kw= '=' )
                    // InternalBlangDsl.g:1377:4: kw= '<' kw= '<' kw= '='
                    {
                    kw=(Token)match(input,34,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_0());
                      			
                    }
                    kw=(Token)match(input,34,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_1());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_5_2());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalBlangDsl.g:1394:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    {
                    // InternalBlangDsl.g:1394:3: (kw= '>' (kw= '>' )? kw= '>=' )
                    // InternalBlangDsl.g:1395:4: kw= '>' (kw= '>' )? kw= '>='
                    {
                    kw=(Token)match(input,35,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0());
                      			
                    }
                    // InternalBlangDsl.g:1400:4: (kw= '>' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==35) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalBlangDsl.g:1401:5: kw= '>'
                            {
                            kw=(Token)match(input,35,FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_1());
                              				
                            }

                            }
                            break;

                    }

                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_6_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // InternalBlangDsl.g:1417:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // InternalBlangDsl.g:1417:54: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // InternalBlangDsl.g:1418:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // InternalBlangDsl.g:1424:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1430:2: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // InternalBlangDsl.g:1431:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // InternalBlangDsl.g:1431:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // InternalBlangDsl.g:1432:3: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_24);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:1440:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==37) ) {
                    int LA17_2 = input.LA(2);

                    if ( (synpred3_InternalBlangDsl()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // InternalBlangDsl.g:1441:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // InternalBlangDsl.g:1441:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // InternalBlangDsl.g:1442:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // InternalBlangDsl.g:1452:5: ( () ( ( ruleOpOr ) ) )
            	    // InternalBlangDsl.g:1453:6: () ( ( ruleOpOr ) )
            	    {
            	    // InternalBlangDsl.g:1453:6: ()
            	    // InternalBlangDsl.g:1454:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalBlangDsl.g:1460:6: ( ( ruleOpOr ) )
            	    // InternalBlangDsl.g:1461:7: ( ruleOpOr )
            	    {
            	    // InternalBlangDsl.g:1461:7: ( ruleOpOr )
            	    // InternalBlangDsl.g:1462:8: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalBlangDsl.g:1478:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // InternalBlangDsl.g:1479:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // InternalBlangDsl.g:1479:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // InternalBlangDsl.g:1480:6: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalBlangDsl.g:1502:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalBlangDsl.g:1502:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalBlangDsl.g:1503:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalBlangDsl.g:1509:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:1515:2: (kw= '||' )
            // InternalBlangDsl.g:1516:2: kw= '||'
            {
            kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // InternalBlangDsl.g:1524:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // InternalBlangDsl.g:1524:55: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // InternalBlangDsl.g:1525:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // InternalBlangDsl.g:1531:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1537:2: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // InternalBlangDsl.g:1538:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // InternalBlangDsl.g:1538:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // InternalBlangDsl.g:1539:3: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_25);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XEqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:1547:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==38) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred4_InternalBlangDsl()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // InternalBlangDsl.g:1548:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // InternalBlangDsl.g:1548:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // InternalBlangDsl.g:1549:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // InternalBlangDsl.g:1559:5: ( () ( ( ruleOpAnd ) ) )
            	    // InternalBlangDsl.g:1560:6: () ( ( ruleOpAnd ) )
            	    {
            	    // InternalBlangDsl.g:1560:6: ()
            	    // InternalBlangDsl.g:1561:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalBlangDsl.g:1567:6: ( ( ruleOpAnd ) )
            	    // InternalBlangDsl.g:1568:7: ( ruleOpAnd )
            	    {
            	    // InternalBlangDsl.g:1568:7: ( ruleOpAnd )
            	    // InternalBlangDsl.g:1569:8: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalBlangDsl.g:1585:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // InternalBlangDsl.g:1586:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // InternalBlangDsl.g:1586:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // InternalBlangDsl.g:1587:6: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XEqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalBlangDsl.g:1609:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalBlangDsl.g:1609:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalBlangDsl.g:1610:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalBlangDsl.g:1616:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:1622:2: (kw= '&&' )
            // InternalBlangDsl.g:1623:2: kw= '&&'
            {
            kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // InternalBlangDsl.g:1631:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // InternalBlangDsl.g:1631:60: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // InternalBlangDsl.g:1632:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // InternalBlangDsl.g:1638:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1644:2: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // InternalBlangDsl.g:1645:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // InternalBlangDsl.g:1645:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // InternalBlangDsl.g:1646:3: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_26);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XRelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:1654:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                switch ( input.LA(1) ) {
                case 39:
                    {
                    int LA19_2 = input.LA(2);

                    if ( (synpred5_InternalBlangDsl()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (synpred5_InternalBlangDsl()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA19_4 = input.LA(2);

                    if ( (synpred5_InternalBlangDsl()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case 42:
                    {
                    int LA19_5 = input.LA(2);

                    if ( (synpred5_InternalBlangDsl()) ) {
                        alt19=1;
                    }


                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // InternalBlangDsl.g:1655:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // InternalBlangDsl.g:1655:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // InternalBlangDsl.g:1656:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // InternalBlangDsl.g:1666:5: ( () ( ( ruleOpEquality ) ) )
            	    // InternalBlangDsl.g:1667:6: () ( ( ruleOpEquality ) )
            	    {
            	    // InternalBlangDsl.g:1667:6: ()
            	    // InternalBlangDsl.g:1668:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalBlangDsl.g:1674:6: ( ( ruleOpEquality ) )
            	    // InternalBlangDsl.g:1675:7: ( ruleOpEquality )
            	    {
            	    // InternalBlangDsl.g:1675:7: ( ruleOpEquality )
            	    // InternalBlangDsl.g:1676:8: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalBlangDsl.g:1692:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // InternalBlangDsl.g:1693:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // InternalBlangDsl.g:1693:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // InternalBlangDsl.g:1694:6: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XRelationalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalBlangDsl.g:1716:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalBlangDsl.g:1716:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalBlangDsl.g:1717:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalBlangDsl.g:1723:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:1729:2: ( (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' ) )
            // InternalBlangDsl.g:1730:2: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            {
            // InternalBlangDsl.g:1730:2: (kw= '==' | kw= '!=' | kw= '===' | kw= '!==' )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt20=1;
                }
                break;
            case 40:
                {
                alt20=2;
                }
                break;
            case 41:
                {
                alt20=3;
                }
                break;
            case 42:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalBlangDsl.g:1731:3: kw= '=='
                    {
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:1737:3: kw= '!='
                    {
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:1743:3: kw= '==='
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBlangDsl.g:1749:3: kw= '!=='
                    {
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // InternalBlangDsl.g:1758:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // InternalBlangDsl.g:1758:62: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // InternalBlangDsl.g:1759:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // InternalBlangDsl.g:1765:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_rightOperand_6_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1771:2: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // InternalBlangDsl.g:1772:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // InternalBlangDsl.g:1772:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // InternalBlangDsl.g:1773:3: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_27);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XOtherOperatorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:1781:3: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop21:
            do {
                int alt21=3;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA21_2 = input.LA(2);

                    if ( (synpred7_InternalBlangDsl()) ) {
                        alt21=2;
                    }


                    }
                    break;
                case 35:
                    {
                    int LA21_3 = input.LA(2);

                    if ( (synpred7_InternalBlangDsl()) ) {
                        alt21=2;
                    }


                    }
                    break;
                case 43:
                    {
                    int LA21_4 = input.LA(2);

                    if ( (synpred6_InternalBlangDsl()) ) {
                        alt21=1;
                    }


                    }
                    break;
                case 36:
                    {
                    int LA21_5 = input.LA(2);

                    if ( (synpred7_InternalBlangDsl()) ) {
                        alt21=2;
                    }


                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // InternalBlangDsl.g:1782:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // InternalBlangDsl.g:1782:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // InternalBlangDsl.g:1783:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // InternalBlangDsl.g:1783:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
            	    // InternalBlangDsl.g:1784:6: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
            	    {
            	    // InternalBlangDsl.g:1790:6: ( () otherlv_2= 'instanceof' )
            	    // InternalBlangDsl.g:1791:7: () otherlv_2= 'instanceof'
            	    {
            	    // InternalBlangDsl.g:1791:7: ()
            	    // InternalBlangDsl.g:1792:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								current = forceCreateModelElementAndSet(
            	      									grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	      									current);
            	      							
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	      						
            	    }

            	    }


            	    }

            	    // InternalBlangDsl.g:1804:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // InternalBlangDsl.g:1805:6: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // InternalBlangDsl.g:1805:6: (lv_type_3_0= ruleJvmTypeReference )
            	    // InternalBlangDsl.g:1806:7: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"type",
            	      								lv_type_3_0,
            	      								"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBlangDsl.g:1825:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // InternalBlangDsl.g:1825:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // InternalBlangDsl.g:1826:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // InternalBlangDsl.g:1826:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // InternalBlangDsl.g:1827:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // InternalBlangDsl.g:1837:6: ( () ( ( ruleOpCompare ) ) )
            	    // InternalBlangDsl.g:1838:7: () ( ( ruleOpCompare ) )
            	    {
            	    // InternalBlangDsl.g:1838:7: ()
            	    // InternalBlangDsl.g:1839:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								current = forceCreateModelElementAndSet(
            	      									grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	      									current);
            	      							
            	    }

            	    }

            	    // InternalBlangDsl.g:1845:7: ( ( ruleOpCompare ) )
            	    // InternalBlangDsl.g:1846:8: ( ruleOpCompare )
            	    {
            	    // InternalBlangDsl.g:1846:8: ( ruleOpCompare )
            	    // InternalBlangDsl.g:1847:9: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      									if (current==null) {
            	      										current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      									}
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
            	      								
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									afterParserOrEnumRuleCall();
            	      								
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalBlangDsl.g:1863:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // InternalBlangDsl.g:1864:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // InternalBlangDsl.g:1864:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // InternalBlangDsl.g:1865:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rightOperand",
            	      								lv_rightOperand_6_0,
            	      								"org.eclipse.xtext.xbase.Xbase.XOtherOperatorExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalBlangDsl.g:1888:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalBlangDsl.g:1888:49: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalBlangDsl.g:1889:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalBlangDsl.g:1895:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:1901:2: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // InternalBlangDsl.g:1902:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // InternalBlangDsl.g:1902:2: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            int alt22=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt22=1;
                }
                break;
            case 34:
                {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==EOF||(LA22_2>=RULE_STRING && LA22_2<=RULE_ID)||LA22_2==15||LA22_2==23||LA22_2==34||(LA22_2>=50 && LA22_2<=51)||LA22_2==56||(LA22_2>=63 && LA22_2<=64)||LA22_2==67||LA22_2==69||(LA22_2>=73 && LA22_2<=75)||(LA22_2>=78 && LA22_2<=90)||LA22_2==92) ) {
                    alt22=4;
                }
                else if ( (LA22_2==20) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
                }
                break;
            case 35:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalBlangDsl.g:1903:3: kw= '>='
                    {
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:1909:3: (kw= '<' kw= '=' )
                    {
                    // InternalBlangDsl.g:1909:3: (kw= '<' kw= '=' )
                    // InternalBlangDsl.g:1910:4: kw= '<' kw= '='
                    {
                    kw=(Token)match(input,34,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:1922:3: kw= '>'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBlangDsl.g:1928:3: kw= '<'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // InternalBlangDsl.g:1937:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // InternalBlangDsl.g:1937:65: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // InternalBlangDsl.g:1938:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // InternalBlangDsl.g:1944:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:1950:2: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // InternalBlangDsl.g:1951:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // InternalBlangDsl.g:1951:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // InternalBlangDsl.g:1952:3: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XAdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:1960:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // InternalBlangDsl.g:1961:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // InternalBlangDsl.g:1961:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // InternalBlangDsl.g:1962:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // InternalBlangDsl.g:1972:5: ( () ( ( ruleOpOther ) ) )
            	    // InternalBlangDsl.g:1973:6: () ( ( ruleOpOther ) )
            	    {
            	    // InternalBlangDsl.g:1973:6: ()
            	    // InternalBlangDsl.g:1974:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalBlangDsl.g:1980:6: ( ( ruleOpOther ) )
            	    // InternalBlangDsl.g:1981:7: ( ruleOpOther )
            	    {
            	    // InternalBlangDsl.g:1981:7: ( ruleOpOther )
            	    // InternalBlangDsl.g:1982:8: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalBlangDsl.g:1998:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // InternalBlangDsl.g:1999:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // InternalBlangDsl.g:1999:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // InternalBlangDsl.g:2000:6: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XAdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // InternalBlangDsl.g:2022:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // InternalBlangDsl.g:2022:47: (iv_ruleOpOther= ruleOpOther EOF )
            // InternalBlangDsl.g:2023:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // InternalBlangDsl.g:2029:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:2035:2: ( (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // InternalBlangDsl.g:2036:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // InternalBlangDsl.g:2036:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt26=9;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalBlangDsl.g:2037:3: kw= '->'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:2043:3: kw= '..<'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:2049:3: (kw= '>' kw= '..' )
                    {
                    // InternalBlangDsl.g:2049:3: (kw= '>' kw= '..' )
                    // InternalBlangDsl.g:2050:4: kw= '>' kw= '..'
                    {
                    kw=(Token)match(input,35,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0());
                      			
                    }
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalBlangDsl.g:2062:3: kw= '..'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBlangDsl.g:2068:3: kw= '=>'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBlangDsl.g:2074:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // InternalBlangDsl.g:2074:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // InternalBlangDsl.g:2075:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    kw=(Token)match(input,35,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0());
                      			
                    }
                    // InternalBlangDsl.g:2080:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==35) ) {
                        int LA24_1 = input.LA(2);

                        if ( (LA24_1==35) && (synpred9_InternalBlangDsl())) {
                            alt24=1;
                        }
                        else if ( (LA24_1==EOF||(LA24_1>=RULE_STRING && LA24_1<=RULE_ID)||LA24_1==15||LA24_1==23||LA24_1==34||(LA24_1>=50 && LA24_1<=51)||LA24_1==56||(LA24_1>=63 && LA24_1<=64)||LA24_1==67||LA24_1==69||(LA24_1>=73 && LA24_1<=75)||(LA24_1>=78 && LA24_1<=90)||LA24_1==92) ) {
                            alt24=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 24, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalBlangDsl.g:2081:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // InternalBlangDsl.g:2081:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // InternalBlangDsl.g:2082:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // InternalBlangDsl.g:2087:6: (kw= '>' kw= '>' )
                            // InternalBlangDsl.g:2088:7: kw= '>' kw= '>'
                            {
                            kw=(Token)match(input,35,FOLLOW_30); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0());
                              						
                            }
                            kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1());
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBlangDsl.g:2101:5: kw= '>'
                            {
                            kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalBlangDsl.g:2109:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // InternalBlangDsl.g:2109:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // InternalBlangDsl.g:2110:4: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    kw=(Token)match(input,34,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0());
                      			
                    }
                    // InternalBlangDsl.g:2115:4: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    int alt25=3;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==34) ) {
                        int LA25_1 = input.LA(2);

                        if ( (synpred10_InternalBlangDsl()) ) {
                            alt25=1;
                        }
                        else if ( (true) ) {
                            alt25=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 25, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA25_0==47) ) {
                        alt25=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalBlangDsl.g:2116:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // InternalBlangDsl.g:2116:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // InternalBlangDsl.g:2117:6: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // InternalBlangDsl.g:2122:6: (kw= '<' kw= '<' )
                            // InternalBlangDsl.g:2123:7: kw= '<' kw= '<'
                            {
                            kw=(Token)match(input,34,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0());
                              						
                            }
                            kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1());
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBlangDsl.g:2136:5: kw= '<'
                            {
                            kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalBlangDsl.g:2142:5: kw= '=>'
                            {
                            kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalBlangDsl.g:2150:3: kw= '<>'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalBlangDsl.g:2156:3: kw= '?:'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // InternalBlangDsl.g:2165:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // InternalBlangDsl.g:2165:60: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // InternalBlangDsl.g:2166:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // InternalBlangDsl.g:2172:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:2178:2: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // InternalBlangDsl.g:2179:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // InternalBlangDsl.g:2179:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // InternalBlangDsl.g:2180:3: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_32);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XMultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:2188:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==50) ) {
                    int LA27_2 = input.LA(2);

                    if ( (synpred11_InternalBlangDsl()) ) {
                        alt27=1;
                    }


                }
                else if ( (LA27_0==51) ) {
                    int LA27_3 = input.LA(2);

                    if ( (synpred11_InternalBlangDsl()) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // InternalBlangDsl.g:2189:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // InternalBlangDsl.g:2189:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // InternalBlangDsl.g:2190:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // InternalBlangDsl.g:2200:5: ( () ( ( ruleOpAdd ) ) )
            	    // InternalBlangDsl.g:2201:6: () ( ( ruleOpAdd ) )
            	    {
            	    // InternalBlangDsl.g:2201:6: ()
            	    // InternalBlangDsl.g:2202:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalBlangDsl.g:2208:6: ( ( ruleOpAdd ) )
            	    // InternalBlangDsl.g:2209:7: ( ruleOpAdd )
            	    {
            	    // InternalBlangDsl.g:2209:7: ( ruleOpAdd )
            	    // InternalBlangDsl.g:2210:8: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalBlangDsl.g:2226:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // InternalBlangDsl.g:2227:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // InternalBlangDsl.g:2227:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // InternalBlangDsl.g:2228:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XMultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalBlangDsl.g:2250:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalBlangDsl.g:2250:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalBlangDsl.g:2251:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalBlangDsl.g:2257:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:2263:2: ( (kw= '+' | kw= '-' ) )
            // InternalBlangDsl.g:2264:2: (kw= '+' | kw= '-' )
            {
            // InternalBlangDsl.g:2264:2: (kw= '+' | kw= '-' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==50) ) {
                alt28=1;
            }
            else if ( (LA28_0==51) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalBlangDsl.g:2265:3: kw= '+'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:2271:3: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // InternalBlangDsl.g:2280:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // InternalBlangDsl.g:2280:66: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // InternalBlangDsl.g:2281:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // InternalBlangDsl.g:2287:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:2293:2: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // InternalBlangDsl.g:2294:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // InternalBlangDsl.g:2294:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // InternalBlangDsl.g:2295:3: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_33);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XUnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:2303:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop29:
            do {
                int alt29=2;
                switch ( input.LA(1) ) {
                case 52:
                    {
                    int LA29_2 = input.LA(2);

                    if ( (synpred12_InternalBlangDsl()) ) {
                        alt29=1;
                    }


                    }
                    break;
                case 53:
                    {
                    int LA29_3 = input.LA(2);

                    if ( (synpred12_InternalBlangDsl()) ) {
                        alt29=1;
                    }


                    }
                    break;
                case 54:
                    {
                    int LA29_4 = input.LA(2);

                    if ( (synpred12_InternalBlangDsl()) ) {
                        alt29=1;
                    }


                    }
                    break;
                case 55:
                    {
                    int LA29_5 = input.LA(2);

                    if ( (synpred12_InternalBlangDsl()) ) {
                        alt29=1;
                    }


                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // InternalBlangDsl.g:2304:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // InternalBlangDsl.g:2304:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // InternalBlangDsl.g:2305:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // InternalBlangDsl.g:2315:5: ( () ( ( ruleOpMulti ) ) )
            	    // InternalBlangDsl.g:2316:6: () ( ( ruleOpMulti ) )
            	    {
            	    // InternalBlangDsl.g:2316:6: ()
            	    // InternalBlangDsl.g:2317:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalBlangDsl.g:2323:6: ( ( ruleOpMulti ) )
            	    // InternalBlangDsl.g:2324:7: ( ruleOpMulti )
            	    {
            	    // InternalBlangDsl.g:2324:7: ( ruleOpMulti )
            	    // InternalBlangDsl.g:2325:8: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalBlangDsl.g:2341:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // InternalBlangDsl.g:2342:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // InternalBlangDsl.g:2342:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // InternalBlangDsl.g:2343:6: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalBlangDsl.g:2365:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalBlangDsl.g:2365:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalBlangDsl.g:2366:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalBlangDsl.g:2372:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:2378:2: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // InternalBlangDsl.g:2379:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // InternalBlangDsl.g:2379:2: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt30=1;
                }
                break;
            case 53:
                {
                alt30=2;
                }
                break;
            case 54:
                {
                alt30=3;
                }
                break;
            case 55:
                {
                alt30=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalBlangDsl.g:2380:3: kw= '*'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:2386:3: kw= '**'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:2392:3: kw= '/'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBlangDsl.g:2398:3: kw= '%'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // InternalBlangDsl.g:2407:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // InternalBlangDsl.g:2407:56: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // InternalBlangDsl.g:2408:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // InternalBlangDsl.g:2414:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:2420:2: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // InternalBlangDsl.g:2421:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // InternalBlangDsl.g:2421:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=50 && LA31_0<=51)||LA31_0==56) ) {
                alt31=1;
            }
            else if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_ID)||LA31_0==15||LA31_0==23||LA31_0==34||(LA31_0>=63 && LA31_0<=64)||LA31_0==67||LA31_0==69||(LA31_0>=73 && LA31_0<=75)||(LA31_0>=78 && LA31_0<=90)||LA31_0==92) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalBlangDsl.g:2422:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    {
                    // InternalBlangDsl.g:2422:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    // InternalBlangDsl.g:2423:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    {
                    // InternalBlangDsl.g:2423:4: ()
                    // InternalBlangDsl.g:2424:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalBlangDsl.g:2430:4: ( ( ruleOpUnary ) )
                    // InternalBlangDsl.g:2431:5: ( ruleOpUnary )
                    {
                    // InternalBlangDsl.g:2431:5: ( ruleOpUnary )
                    // InternalBlangDsl.g:2432:6: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:2446:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    // InternalBlangDsl.g:2447:5: (lv_operand_2_0= ruleXUnaryOperation )
                    {
                    // InternalBlangDsl.g:2447:5: (lv_operand_2_0= ruleXUnaryOperation )
                    // InternalBlangDsl.g:2448:6: lv_operand_2_0= ruleXUnaryOperation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleXUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:2467:3: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XCastedExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalBlangDsl.g:2479:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalBlangDsl.g:2479:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalBlangDsl.g:2480:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalBlangDsl.g:2486:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:2492:2: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // InternalBlangDsl.g:2493:2: (kw= '!' | kw= '-' | kw= '+' )
            {
            // InternalBlangDsl.g:2493:2: (kw= '!' | kw= '-' | kw= '+' )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt32=1;
                }
                break;
            case 51:
                {
                alt32=2;
                }
                break;
            case 50:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalBlangDsl.g:2494:3: kw= '!'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:2500:3: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:2506:3: kw= '+'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // InternalBlangDsl.g:2515:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // InternalBlangDsl.g:2515:58: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // InternalBlangDsl.g:2516:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // InternalBlangDsl.g:2522:1: ruleXCastedExpression returns [EObject current=null] : (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XPostfixOperation_0 = null;

        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:2528:2: ( (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // InternalBlangDsl.g:2529:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // InternalBlangDsl.g:2529:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // InternalBlangDsl.g:2530:3: this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_34);
            this_XPostfixOperation_0=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XPostfixOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:2538:3: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==57) ) {
                    int LA33_2 = input.LA(2);

                    if ( (synpred13_InternalBlangDsl()) ) {
                        alt33=1;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // InternalBlangDsl.g:2539:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // InternalBlangDsl.g:2539:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
            	    // InternalBlangDsl.g:2540:5: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
            	    {
            	    // InternalBlangDsl.g:2546:5: ( () otherlv_2= 'as' )
            	    // InternalBlangDsl.g:2547:6: () otherlv_2= 'as'
            	    {
            	    // InternalBlangDsl.g:2547:6: ()
            	    // InternalBlangDsl.g:2548:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    otherlv_2=(Token)match(input,57,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	      					
            	    }

            	    }


            	    }

            	    // InternalBlangDsl.g:2560:4: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // InternalBlangDsl.g:2561:5: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // InternalBlangDsl.g:2561:5: (lv_type_3_0= ruleJvmTypeReference )
            	    // InternalBlangDsl.g:2562:6: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"type",
            	      							lv_type_3_0,
            	      							"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXPostfixOperation"
    // InternalBlangDsl.g:2584:1: entryRuleXPostfixOperation returns [EObject current=null] : iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
    public final EObject entryRuleXPostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPostfixOperation = null;


        try {
            // InternalBlangDsl.g:2584:58: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
            // InternalBlangDsl.g:2585:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPostfixOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPostfixOperation=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPostfixOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXPostfixOperation"


    // $ANTLR start "ruleXPostfixOperation"
    // InternalBlangDsl.g:2591:1: ruleXPostfixOperation returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) ;
    public final EObject ruleXPostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject this_XMemberFeatureCall_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:2597:2: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) )
            // InternalBlangDsl.g:2598:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            {
            // InternalBlangDsl.g:2598:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            // InternalBlangDsl.g:2599:3: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XMemberFeatureCall_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:2607:3: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==58) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred14_InternalBlangDsl()) ) {
                    alt34=1;
                }
            }
            else if ( (LA34_0==59) ) {
                int LA34_2 = input.LA(2);

                if ( (synpred14_InternalBlangDsl()) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // InternalBlangDsl.g:2608:4: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
                    {
                    // InternalBlangDsl.g:2618:4: ( () ( ( ruleOpPostfix ) ) )
                    // InternalBlangDsl.g:2619:5: () ( ( ruleOpPostfix ) )
                    {
                    // InternalBlangDsl.g:2619:5: ()
                    // InternalBlangDsl.g:2620:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalBlangDsl.g:2626:5: ( ( ruleOpPostfix ) )
                    // InternalBlangDsl.g:2627:6: ( ruleOpPostfix )
                    {
                    // InternalBlangDsl.g:2627:6: ( ruleOpPostfix )
                    // InternalBlangDsl.g:2628:7: ruleOpPostfix
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXPostfixOperationRule());
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    ruleOpPostfix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXPostfixOperation"


    // $ANTLR start "entryRuleOpPostfix"
    // InternalBlangDsl.g:2648:1: entryRuleOpPostfix returns [String current=null] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final String entryRuleOpPostfix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpPostfix = null;


        try {
            // InternalBlangDsl.g:2648:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // InternalBlangDsl.g:2649:2: iv_ruleOpPostfix= ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpPostfixRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpPostfix=ruleOpPostfix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpPostfix.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // InternalBlangDsl.g:2655:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' | kw= '--' ) ;
    public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:2661:2: ( (kw= '++' | kw= '--' ) )
            // InternalBlangDsl.g:2662:2: (kw= '++' | kw= '--' )
            {
            // InternalBlangDsl.g:2662:2: (kw= '++' | kw= '--' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==58) ) {
                alt35=1;
            }
            else if ( (LA35_0==59) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalBlangDsl.g:2663:3: kw= '++'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:2669:3: kw= '--'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // InternalBlangDsl.g:2678:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // InternalBlangDsl.g:2678:59: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // InternalBlangDsl.g:2679:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // InternalBlangDsl.g:2685:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitStatic_3_0=null;
        Token otherlv_8=null;
        Token lv_nullSafe_9_0=null;
        Token lv_explicitStatic_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_explicitOperationCall_17_0=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_value_6_0 = null;

        EObject lv_typeArguments_12_0 = null;

        EObject lv_typeArguments_14_0 = null;

        EObject lv_memberCallArguments_18_0 = null;

        EObject lv_memberCallArguments_19_0 = null;

        EObject lv_memberCallArguments_21_0 = null;

        EObject lv_memberCallArguments_23_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:2691:2: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) )
            // InternalBlangDsl.g:2692:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            {
            // InternalBlangDsl.g:2692:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            // InternalBlangDsl.g:2693:3: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_36);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XPrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:2701:3: ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            loop44:
            do {
                int alt44=3;
                switch ( input.LA(1) ) {
                case 60:
                    {
                    int LA44_2 = input.LA(2);

                    if ( (synpred15_InternalBlangDsl()) ) {
                        alt44=1;
                    }
                    else if ( (synpred16_InternalBlangDsl()) ) {
                        alt44=2;
                    }


                    }
                    break;
                case 61:
                    {
                    int LA44_3 = input.LA(2);

                    if ( (synpred15_InternalBlangDsl()) ) {
                        alt44=1;
                    }
                    else if ( (synpred16_InternalBlangDsl()) ) {
                        alt44=2;
                    }


                    }
                    break;
                case 62:
                    {
                    int LA44_4 = input.LA(2);

                    if ( (synpred16_InternalBlangDsl()) ) {
                        alt44=2;
                    }


                    }
                    break;

                }

                switch (alt44) {
            	case 1 :
            	    // InternalBlangDsl.g:2702:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    {
            	    // InternalBlangDsl.g:2702:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    // InternalBlangDsl.g:2703:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) )
            	    {
            	    // InternalBlangDsl.g:2703:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
            	    // InternalBlangDsl.g:2704:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    {
            	    // InternalBlangDsl.g:2724:6: ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    // InternalBlangDsl.g:2725:7: () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
            	    {
            	    // InternalBlangDsl.g:2725:7: ()
            	    // InternalBlangDsl.g:2726:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								current = forceCreateModelElementAndSet(
            	      									grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	      									current);
            	      							
            	    }

            	    }

            	    // InternalBlangDsl.g:2732:7: (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) )
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==60) ) {
            	        alt36=1;
            	    }
            	    else if ( (LA36_0==61) ) {
            	        alt36=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // InternalBlangDsl.g:2733:8: otherlv_2= '.'
            	            {
            	            otherlv_2=(Token)match(input,60,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0());
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBlangDsl.g:2738:8: ( (lv_explicitStatic_3_0= '::' ) )
            	            {
            	            // InternalBlangDsl.g:2738:8: ( (lv_explicitStatic_3_0= '::' ) )
            	            // InternalBlangDsl.g:2739:9: (lv_explicitStatic_3_0= '::' )
            	            {
            	            // InternalBlangDsl.g:2739:9: (lv_explicitStatic_3_0= '::' )
            	            // InternalBlangDsl.g:2740:10: lv_explicitStatic_3_0= '::'
            	            {
            	            lv_explicitStatic_3_0=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										newLeafNode(lv_explicitStatic_3_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0());
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              										}
            	              										setWithLastConsumed(current, "explicitStatic", true, "::");
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalBlangDsl.g:2753:7: ( ( ruleFeatureCallID ) )
            	    // InternalBlangDsl.g:2754:8: ( ruleFeatureCallID )
            	    {
            	    // InternalBlangDsl.g:2754:8: ( ruleFeatureCallID )
            	    // InternalBlangDsl.g:2755:9: ruleFeatureCallID
            	    {
            	    if ( state.backtracking==0 ) {

            	      									if (current==null) {
            	      										current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      									}
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0());
            	      								
            	    }
            	    pushFollow(FOLLOW_12);
            	    ruleFeatureCallID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									afterParserOrEnumRuleCall();
            	      								
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3());
            	      						
            	    }
            	    pushFollow(FOLLOW_13);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalBlangDsl.g:2778:5: ( (lv_value_6_0= ruleXAssignment ) )
            	    // InternalBlangDsl.g:2779:6: (lv_value_6_0= ruleXAssignment )
            	    {
            	    // InternalBlangDsl.g:2779:6: (lv_value_6_0= ruleXAssignment )
            	    // InternalBlangDsl.g:2780:7: lv_value_6_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_value_6_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	      							}
            	      							set(
            	      								current,
            	      								"value",
            	      								lv_value_6_0,
            	      								"org.eclipse.xtext.xbase.Xbase.XAssignment");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalBlangDsl.g:2799:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    {
            	    // InternalBlangDsl.g:2799:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    // InternalBlangDsl.g:2800:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    {
            	    // InternalBlangDsl.g:2800:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) )
            	    // InternalBlangDsl.g:2801:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    {
            	    // InternalBlangDsl.g:2821:6: ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
            	    // InternalBlangDsl.g:2822:7: () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    {
            	    // InternalBlangDsl.g:2822:7: ()
            	    // InternalBlangDsl.g:2823:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								current = forceCreateModelElementAndSet(
            	      									grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	      									current);
            	      							
            	    }

            	    }

            	    // InternalBlangDsl.g:2829:7: (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
            	    int alt37=3;
            	    switch ( input.LA(1) ) {
            	    case 60:
            	        {
            	        alt37=1;
            	        }
            	        break;
            	    case 62:
            	        {
            	        alt37=2;
            	        }
            	        break;
            	    case 61:
            	        {
            	        alt37=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt37) {
            	        case 1 :
            	            // InternalBlangDsl.g:2830:8: otherlv_8= '.'
            	            {
            	            otherlv_8=(Token)match(input,60,FOLLOW_38); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalBlangDsl.g:2835:8: ( (lv_nullSafe_9_0= '?.' ) )
            	            {
            	            // InternalBlangDsl.g:2835:8: ( (lv_nullSafe_9_0= '?.' ) )
            	            // InternalBlangDsl.g:2836:9: (lv_nullSafe_9_0= '?.' )
            	            {
            	            // InternalBlangDsl.g:2836:9: (lv_nullSafe_9_0= '?.' )
            	            // InternalBlangDsl.g:2837:10: lv_nullSafe_9_0= '?.'
            	            {
            	            lv_nullSafe_9_0=(Token)match(input,62,FOLLOW_38); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										newLeafNode(lv_nullSafe_9_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              										}
            	              										setWithLastConsumed(current, "nullSafe", true, "?.");
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalBlangDsl.g:2850:8: ( (lv_explicitStatic_10_0= '::' ) )
            	            {
            	            // InternalBlangDsl.g:2850:8: ( (lv_explicitStatic_10_0= '::' ) )
            	            // InternalBlangDsl.g:2851:9: (lv_explicitStatic_10_0= '::' )
            	            {
            	            // InternalBlangDsl.g:2851:9: (lv_explicitStatic_10_0= '::' )
            	            // InternalBlangDsl.g:2852:10: lv_explicitStatic_10_0= '::'
            	            {
            	            lv_explicitStatic_10_0=(Token)match(input,61,FOLLOW_38); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										newLeafNode(lv_explicitStatic_10_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0());
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              										}
            	              										setWithLastConsumed(current, "explicitStatic", true, "::");
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalBlangDsl.g:2867:5: (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )?
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( (LA39_0==34) ) {
            	        alt39=1;
            	    }
            	    switch (alt39) {
            	        case 1 :
            	            // InternalBlangDsl.g:2868:6: otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>'
            	            {
            	            otherlv_11=(Token)match(input,34,FOLLOW_39); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	              					
            	            }
            	            // InternalBlangDsl.g:2872:6: ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) )
            	            // InternalBlangDsl.g:2873:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            {
            	            // InternalBlangDsl.g:2873:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            // InternalBlangDsl.g:2874:8: lv_typeArguments_12_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {

            	              								newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0());
            	              							
            	            }
            	            pushFollow(FOLLOW_40);
            	            lv_typeArguments_12_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              								}
            	              								add(
            	              									current,
            	              									"typeArguments",
            	              									lv_typeArguments_12_0,
            	              									"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
            	              								afterParserOrEnumRuleCall();
            	              							
            	            }

            	            }


            	            }

            	            // InternalBlangDsl.g:2891:6: (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop38:
            	            do {
            	                int alt38=2;
            	                int LA38_0 = input.LA(1);

            	                if ( (LA38_0==24) ) {
            	                    alt38=1;
            	                }


            	                switch (alt38) {
            	            	case 1 :
            	            	    // InternalBlangDsl.g:2892:7: otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_13=(Token)match(input,24,FOLLOW_39); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      							newLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	      						
            	            	    }
            	            	    // InternalBlangDsl.g:2896:7: ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    // InternalBlangDsl.g:2897:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // InternalBlangDsl.g:2897:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    // InternalBlangDsl.g:2898:9: lv_typeArguments_14_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0());
            	            	      								
            	            	    }
            	            	    pushFollow(FOLLOW_40);
            	            	    lv_typeArguments_14_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      									if (current==null) {
            	            	      										current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	            	      									}
            	            	      									add(
            	            	      										current,
            	            	      										"typeArguments",
            	            	      										lv_typeArguments_14_0,
            	            	      										"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
            	            	      									afterParserOrEnumRuleCall();
            	            	      								
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop38;
            	                }
            	            } while (true);

            	            otherlv_15=(Token)match(input,35,FOLLOW_38); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // InternalBlangDsl.g:2921:5: ( ( ruleIdOrSuper ) )
            	    // InternalBlangDsl.g:2922:6: ( ruleIdOrSuper )
            	    {
            	    // InternalBlangDsl.g:2922:6: ( ruleIdOrSuper )
            	    // InternalBlangDsl.g:2923:7: ruleIdOrSuper
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_41);
            	    ruleIdOrSuper();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalBlangDsl.g:2937:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?
            	    int alt42=2;
            	    alt42 = dfa42.predict(input);
            	    switch (alt42) {
            	        case 1 :
            	            // InternalBlangDsl.g:2938:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')'
            	            {
            	            // InternalBlangDsl.g:2938:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) )
            	            // InternalBlangDsl.g:2939:7: ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' )
            	            {
            	            // InternalBlangDsl.g:2943:7: (lv_explicitOperationCall_17_0= '(' )
            	            // InternalBlangDsl.g:2944:8: lv_explicitOperationCall_17_0= '('
            	            {
            	            lv_explicitOperationCall_17_0=(Token)match(input,23,FOLLOW_42); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_explicitOperationCall_17_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              								}
            	              								setWithLastConsumed(current, "explicitOperationCall", true, "(");
            	              							
            	            }

            	            }


            	            }

            	            // InternalBlangDsl.g:2956:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?
            	            int alt41=3;
            	            alt41 = dfa41.predict(input);
            	            switch (alt41) {
            	                case 1 :
            	                    // InternalBlangDsl.g:2957:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    {
            	                    // InternalBlangDsl.g:2957:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    // InternalBlangDsl.g:2958:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    {
            	                    // InternalBlangDsl.g:2983:8: (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    // InternalBlangDsl.g:2984:9: lv_memberCallArguments_18_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_43);
            	                    lv_memberCallArguments_18_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      									}
            	                      									add(
            	                      										current,
            	                      										"memberCallArguments",
            	                      										lv_memberCallArguments_18_0,
            	                      										"org.eclipse.xtext.xbase.Xbase.XShortClosure");
            	                      									afterParserOrEnumRuleCall();
            	                      								
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalBlangDsl.g:3002:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    {
            	                    // InternalBlangDsl.g:3002:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    // InternalBlangDsl.g:3003:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    {
            	                    // InternalBlangDsl.g:3003:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) )
            	                    // InternalBlangDsl.g:3004:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    {
            	                    // InternalBlangDsl.g:3004:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    // InternalBlangDsl.g:3005:10: lv_memberCallArguments_19_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      										newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0());
            	                      									
            	                    }
            	                    pushFollow(FOLLOW_16);
            	                    lv_memberCallArguments_19_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      										if (current==null) {
            	                      											current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      										}
            	                      										add(
            	                      											current,
            	                      											"memberCallArguments",
            	                      											lv_memberCallArguments_19_0,
            	                      											"org.eclipse.xtext.xbase.Xbase.XExpression");
            	                      										afterParserOrEnumRuleCall();
            	                      									
            	                    }

            	                    }


            	                    }

            	                    // InternalBlangDsl.g:3022:8: (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    loop40:
            	                    do {
            	                        int alt40=2;
            	                        int LA40_0 = input.LA(1);

            	                        if ( (LA40_0==24) ) {
            	                            alt40=1;
            	                        }


            	                        switch (alt40) {
            	                    	case 1 :
            	                    	    // InternalBlangDsl.g:3023:9: otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_20=(Token)match(input,24,FOLLOW_13); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									newLeafNode(otherlv_20, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	      								
            	                    	    }
            	                    	    // InternalBlangDsl.g:3027:9: ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    // InternalBlangDsl.g:3028:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    {
            	                    	    // InternalBlangDsl.g:3028:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    // InternalBlangDsl.g:3029:11: lv_memberCallArguments_21_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0());
            	                    	      										
            	                    	    }
            	                    	    pushFollow(FOLLOW_16);
            	                    	    lv_memberCallArguments_21_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											if (current==null) {
            	                    	      												current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                    	      											}
            	                    	      											add(
            	                    	      												current,
            	                    	      												"memberCallArguments",
            	                    	      												lv_memberCallArguments_21_0,
            	                    	      												"org.eclipse.xtext.xbase.Xbase.XExpression");
            	                    	      											afterParserOrEnumRuleCall();
            	                    	      										
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop40;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_22=(Token)match(input,25,FOLLOW_44); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_22, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // InternalBlangDsl.g:3054:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    int alt43=2;
            	    alt43 = dfa43.predict(input);
            	    switch (alt43) {
            	        case 1 :
            	            // InternalBlangDsl.g:3055:6: ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure )
            	            {
            	            // InternalBlangDsl.g:3061:6: (lv_memberCallArguments_23_0= ruleXClosure )
            	            // InternalBlangDsl.g:3062:7: lv_memberCallArguments_23_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_36);
            	            lv_memberCallArguments_23_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              							}
            	              							add(
            	              								current,
            	              								"memberCallArguments",
            	              								lv_memberCallArguments_23_0,
            	              								"org.eclipse.xtext.xbase.Xbase.XClosure");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // InternalBlangDsl.g:3085:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // InternalBlangDsl.g:3085:59: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // InternalBlangDsl.g:3086:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // InternalBlangDsl.g:3092:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XSynchronizedExpression_3 = null;

        EObject this_XFeatureCall_4 = null;

        EObject this_XLiteral_5 = null;

        EObject this_XIfExpression_6 = null;

        EObject this_XForLoopExpression_7 = null;

        EObject this_XBasicForLoopExpression_8 = null;

        EObject this_XWhileExpression_9 = null;

        EObject this_XDoWhileExpression_10 = null;

        EObject this_XThrowExpression_11 = null;

        EObject this_XReturnExpression_12 = null;

        EObject this_XTryCatchFinallyExpression_13 = null;

        EObject this_XParenthesizedExpression_14 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3098:2: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) )
            // InternalBlangDsl.g:3099:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            {
            // InternalBlangDsl.g:3099:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            int alt45=15;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // InternalBlangDsl.g:3100:3: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XConstructorCall_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:3109:3: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBlockExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:3118:3: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XSwitchExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBlangDsl.g:3127:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    {
                    // InternalBlangDsl.g:3127:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    // InternalBlangDsl.g:3128:4: ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSynchronizedExpressionParserRuleCall_3());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XSynchronizedExpression_3=ruleXSynchronizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XSynchronizedExpression_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalBlangDsl.g:3145:3: this_XFeatureCall_4= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XFeatureCall_4=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XFeatureCall_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBlangDsl.g:3154:3: this_XLiteral_5= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XLiteral_5=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalBlangDsl.g:3163:3: this_XIfExpression_6= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XIfExpression_6=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XIfExpression_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalBlangDsl.g:3172:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    {
                    // InternalBlangDsl.g:3172:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    // InternalBlangDsl.g:3173:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XForLoopExpression_7=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XForLoopExpression_7;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalBlangDsl.g:3196:3: this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBasicForLoopExpressionParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBasicForLoopExpression_8=ruleXBasicForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBasicForLoopExpression_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalBlangDsl.g:3205:3: this_XWhileExpression_9= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XWhileExpression_9=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XWhileExpression_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalBlangDsl.g:3214:3: this_XDoWhileExpression_10= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XDoWhileExpression_10=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XDoWhileExpression_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalBlangDsl.g:3223:3: this_XThrowExpression_11= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_11());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XThrowExpression_11=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XThrowExpression_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalBlangDsl.g:3232:3: this_XReturnExpression_12= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_12());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XReturnExpression_12=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XReturnExpression_12;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalBlangDsl.g:3241:3: this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_13());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTryCatchFinallyExpression_13=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTryCatchFinallyExpression_13;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalBlangDsl.g:3250:3: this_XParenthesizedExpression_14= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_14());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XParenthesizedExpression_14=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XParenthesizedExpression_14;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // InternalBlangDsl.g:3262:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // InternalBlangDsl.g:3262:49: (iv_ruleXLiteral= ruleXLiteral EOF )
            // InternalBlangDsl.g:3263:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // InternalBlangDsl.g:3269:1: ruleXLiteral returns [EObject current=null] : (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XCollectionLiteral_0 = null;

        EObject this_XClosure_1 = null;

        EObject this_XBooleanLiteral_2 = null;

        EObject this_XNumberLiteral_3 = null;

        EObject this_XNullLiteral_4 = null;

        EObject this_XStringLiteral_5 = null;

        EObject this_XTypeLiteral_6 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3275:2: ( (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) )
            // InternalBlangDsl.g:3276:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            {
            // InternalBlangDsl.g:3276:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            int alt46=7;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==63) ) {
                alt46=1;
            }
            else if ( (LA46_0==64) && (synpred22_InternalBlangDsl())) {
                alt46=2;
            }
            else if ( ((LA46_0>=84 && LA46_0<=85)) ) {
                alt46=3;
            }
            else if ( ((LA46_0>=RULE_HEX && LA46_0<=RULE_DECIMAL)) ) {
                alt46=4;
            }
            else if ( (LA46_0==86) ) {
                alt46=5;
            }
            else if ( (LA46_0==RULE_STRING) ) {
                alt46=6;
            }
            else if ( (LA46_0==87) ) {
                alt46=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalBlangDsl.g:3277:3: this_XCollectionLiteral_0= ruleXCollectionLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXCollectionLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XCollectionLiteral_0=ruleXCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XCollectionLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:3286:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
                    {
                    // InternalBlangDsl.g:3286:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
                    // InternalBlangDsl.g:3287:4: ( ( () '[' ) )=>this_XClosure_1= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XClosure_1=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XClosure_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:3303:3: this_XBooleanLiteral_2= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBooleanLiteral_2=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBooleanLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBlangDsl.g:3312:3: this_XNumberLiteral_3= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XNumberLiteral_3=ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XNumberLiteral_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBlangDsl.g:3321:3: this_XNullLiteral_4= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XNullLiteral_4=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XNullLiteral_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBlangDsl.g:3330:3: this_XStringLiteral_5= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XStringLiteral_5=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XStringLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalBlangDsl.g:3339:3: this_XTypeLiteral_6= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTypeLiteral_6=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTypeLiteral_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXCollectionLiteral"
    // InternalBlangDsl.g:3351:1: entryRuleXCollectionLiteral returns [EObject current=null] : iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF ;
    public final EObject entryRuleXCollectionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCollectionLiteral = null;


        try {
            // InternalBlangDsl.g:3351:59: (iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF )
            // InternalBlangDsl.g:3352:2: iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCollectionLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCollectionLiteral=ruleXCollectionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCollectionLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCollectionLiteral"


    // $ANTLR start "ruleXCollectionLiteral"
    // InternalBlangDsl.g:3358:1: ruleXCollectionLiteral returns [EObject current=null] : (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) ;
    public final EObject ruleXCollectionLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XSetLiteral_0 = null;

        EObject this_XListLiteral_1 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3364:2: ( (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) )
            // InternalBlangDsl.g:3365:2: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            {
            // InternalBlangDsl.g:3365:2: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==63) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==64) ) {
                    alt47=2;
                }
                else if ( (LA47_1==15) ) {
                    alt47=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalBlangDsl.g:3366:3: this_XSetLiteral_0= ruleXSetLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXSetLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XSetLiteral_0=ruleXSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XSetLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:3375:3: this_XListLiteral_1= ruleXListLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXListLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XListLiteral_1=ruleXListLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XListLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCollectionLiteral"


    // $ANTLR start "entryRuleXSetLiteral"
    // InternalBlangDsl.g:3387:1: entryRuleXSetLiteral returns [EObject current=null] : iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
    public final EObject entryRuleXSetLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSetLiteral = null;


        try {
            // InternalBlangDsl.g:3387:52: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
            // InternalBlangDsl.g:3388:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSetLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSetLiteral=ruleXSetLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSetLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSetLiteral"


    // $ANTLR start "ruleXSetLiteral"
    // InternalBlangDsl.g:3394:1: ruleXSetLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleXSetLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_5_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3400:2: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
            // InternalBlangDsl.g:3401:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            {
            // InternalBlangDsl.g:3401:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
            // InternalBlangDsl.g:3402:3: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
            {
            // InternalBlangDsl.g:3402:3: ()
            // InternalBlangDsl.g:3403:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,15,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalBlangDsl.g:3417:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)||LA49_0==15||LA49_0==23||LA49_0==34||(LA49_0>=50 && LA49_0<=51)||LA49_0==56||(LA49_0>=63 && LA49_0<=64)||LA49_0==67||LA49_0==69||(LA49_0>=73 && LA49_0<=75)||(LA49_0>=78 && LA49_0<=90)||LA49_0==92) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBlangDsl.g:3418:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // InternalBlangDsl.g:3418:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // InternalBlangDsl.g:3419:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:3419:5: (lv_elements_3_0= ruleXExpression )
                    // InternalBlangDsl.g:3420:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_46);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
                      						}
                      						add(
                      							current,
                      							"elements",
                      							lv_elements_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:3437:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==24) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalBlangDsl.g:3438:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalBlangDsl.g:3442:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // InternalBlangDsl.g:3443:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // InternalBlangDsl.g:3443:6: (lv_elements_5_0= ruleXExpression )
                    	    // InternalBlangDsl.g:3444:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_46);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"elements",
                    	      								lv_elements_5_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXSetLiteralAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSetLiteral"


    // $ANTLR start "entryRuleXListLiteral"
    // InternalBlangDsl.g:3471:1: entryRuleXListLiteral returns [EObject current=null] : iv_ruleXListLiteral= ruleXListLiteral EOF ;
    public final EObject entryRuleXListLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXListLiteral = null;


        try {
            // InternalBlangDsl.g:3471:53: (iv_ruleXListLiteral= ruleXListLiteral EOF )
            // InternalBlangDsl.g:3472:2: iv_ruleXListLiteral= ruleXListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXListLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXListLiteral=ruleXListLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXListLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXListLiteral"


    // $ANTLR start "ruleXListLiteral"
    // InternalBlangDsl.g:3478:1: ruleXListLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
    public final EObject ruleXListLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_5_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3484:2: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
            // InternalBlangDsl.g:3485:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            {
            // InternalBlangDsl.g:3485:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
            // InternalBlangDsl.g:3486:3: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
            {
            // InternalBlangDsl.g:3486:3: ()
            // InternalBlangDsl.g:3487:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXListLiteralAccess().getXListLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,64,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalBlangDsl.g:3501:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_STRING && LA51_0<=RULE_ID)||LA51_0==15||LA51_0==23||LA51_0==34||(LA51_0>=50 && LA51_0<=51)||LA51_0==56||(LA51_0>=63 && LA51_0<=64)||LA51_0==67||LA51_0==69||(LA51_0>=73 && LA51_0<=75)||(LA51_0>=78 && LA51_0<=90)||LA51_0==92) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBlangDsl.g:3502:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // InternalBlangDsl.g:3502:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // InternalBlangDsl.g:3503:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:3503:5: (lv_elements_3_0= ruleXExpression )
                    // InternalBlangDsl.g:3504:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_49);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXListLiteralRule());
                      						}
                      						add(
                      							current,
                      							"elements",
                      							lv_elements_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:3521:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==24) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalBlangDsl.g:3522:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalBlangDsl.g:3526:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // InternalBlangDsl.g:3527:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // InternalBlangDsl.g:3527:6: (lv_elements_5_0= ruleXExpression )
                    	    // InternalBlangDsl.g:3528:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_49);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXListLiteralRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"elements",
                    	      								lv_elements_5_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXListLiteralAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXListLiteral"


    // $ANTLR start "entryRuleXClosure"
    // InternalBlangDsl.g:3555:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // InternalBlangDsl.g:3555:49: (iv_ruleXClosure= ruleXClosure EOF )
            // InternalBlangDsl.g:3556:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // InternalBlangDsl.g:3562:1: ruleXClosure returns [EObject current=null] : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        EObject lv_declaredFormalParameters_2_0 = null;

        EObject lv_declaredFormalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3568:2: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
            // InternalBlangDsl.g:3569:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            {
            // InternalBlangDsl.g:3569:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
            // InternalBlangDsl.g:3570:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
            {
            // InternalBlangDsl.g:3570:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
            // InternalBlangDsl.g:3571:4: ( ( () '[' ) )=> ( () otherlv_1= '[' )
            {
            // InternalBlangDsl.g:3577:4: ( () otherlv_1= '[' )
            // InternalBlangDsl.g:3578:5: () otherlv_1= '['
            {
            // InternalBlangDsl.g:3578:5: ()
            // InternalBlangDsl.g:3579:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getXClosureAccess().getXClosureAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
              				
            }

            }


            }

            // InternalBlangDsl.g:3591:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // InternalBlangDsl.g:3592:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    {
                    // InternalBlangDsl.g:3615:4: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
                    // InternalBlangDsl.g:3616:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
                    {
                    // InternalBlangDsl.g:3616:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==RULE_ID||LA53_0==23||LA53_0==47) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalBlangDsl.g:3617:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // InternalBlangDsl.g:3617:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // InternalBlangDsl.g:3618:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // InternalBlangDsl.g:3618:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // InternalBlangDsl.g:3619:8: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0());
                              							
                            }
                            pushFollow(FOLLOW_51);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXClosureRule());
                              								}
                              								add(
                              									current,
                              									"declaredFormalParameters",
                              									lv_declaredFormalParameters_2_0,
                              									"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalBlangDsl.g:3636:6: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==24) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // InternalBlangDsl.g:3637:7: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,24,FOLLOW_11); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
                            	      						
                            	    }
                            	    // InternalBlangDsl.g:3641:7: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // InternalBlangDsl.g:3642:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // InternalBlangDsl.g:3642:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // InternalBlangDsl.g:3643:9: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_51);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getXClosureRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"declaredFormalParameters",
                            	      										lv_declaredFormalParameters_4_0,
                            	      										"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop52;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalBlangDsl.g:3662:5: ( (lv_explicitSyntax_5_0= '|' ) )
                    // InternalBlangDsl.g:3663:6: (lv_explicitSyntax_5_0= '|' )
                    {
                    // InternalBlangDsl.g:3663:6: (lv_explicitSyntax_5_0= '|' )
                    // InternalBlangDsl.g:3664:7: lv_explicitSyntax_5_0= '|'
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,27,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXClosureRule());
                      							}
                      							setWithLastConsumed(current, "explicitSyntax", true, "|");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalBlangDsl.g:3678:3: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // InternalBlangDsl.g:3679:4: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // InternalBlangDsl.g:3679:4: (lv_expression_6_0= ruleXExpressionInClosure )
            // InternalBlangDsl.g:3680:5: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_53);
            lv_expression_6_0=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXClosureRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_6_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpressionInClosure");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // InternalBlangDsl.g:3705:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // InternalBlangDsl.g:3705:61: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // InternalBlangDsl.g:3706:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // InternalBlangDsl.g:3712:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3718:2: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
            // InternalBlangDsl.g:3719:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            {
            // InternalBlangDsl.g:3719:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
            // InternalBlangDsl.g:3720:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            {
            // InternalBlangDsl.g:3720:3: ()
            // InternalBlangDsl.g:3721:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:3727:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=RULE_STRING && LA56_0<=RULE_ID)||LA56_0==15||LA56_0==23||LA56_0==34||(LA56_0>=50 && LA56_0<=51)||LA56_0==56||(LA56_0>=63 && LA56_0<=64)||LA56_0==67||LA56_0==69||(LA56_0>=73 && LA56_0<=90)||LA56_0==92) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBlangDsl.g:3728:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
            	    {
            	    // InternalBlangDsl.g:3728:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
            	    // InternalBlangDsl.g:3729:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // InternalBlangDsl.g:3729:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    // InternalBlangDsl.g:3730:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
            	    lv_expressions_1_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_1_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalBlangDsl.g:3747:4: (otherlv_2= ';' )?
            	    int alt55=2;
            	    int LA55_0 = input.LA(1);

            	    if ( (LA55_0==66) ) {
            	        alt55=1;
            	    }
            	    switch (alt55) {
            	        case 1 :
            	            // InternalBlangDsl.g:3748:5: otherlv_2= ';'
            	            {
            	            otherlv_2=(Token)match(input,66,FOLLOW_55); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // InternalBlangDsl.g:3758:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // InternalBlangDsl.g:3758:54: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // InternalBlangDsl.g:3759:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // InternalBlangDsl.g:3765:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3771:2: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // InternalBlangDsl.g:3772:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // InternalBlangDsl.g:3772:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // InternalBlangDsl.g:3773:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // InternalBlangDsl.g:3773:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
            // InternalBlangDsl.g:3774:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            {
            // InternalBlangDsl.g:3799:4: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
            // InternalBlangDsl.g:3800:5: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
            {
            // InternalBlangDsl.g:3800:5: ()
            // InternalBlangDsl.g:3801:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
              							current);
              					
            }

            }

            // InternalBlangDsl.g:3807:5: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID||LA58_0==23||LA58_0==47) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalBlangDsl.g:3808:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // InternalBlangDsl.g:3808:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // InternalBlangDsl.g:3809:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // InternalBlangDsl.g:3809:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // InternalBlangDsl.g:3810:8: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0());
                      							
                    }
                    pushFollow(FOLLOW_51);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      								}
                      								add(
                      									current,
                      									"declaredFormalParameters",
                      									lv_declaredFormalParameters_1_0,
                      									"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }

                    // InternalBlangDsl.g:3827:6: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==24) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalBlangDsl.g:3828:7: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,24,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	      						
                    	    }
                    	    // InternalBlangDsl.g:3832:7: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // InternalBlangDsl.g:3833:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // InternalBlangDsl.g:3833:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // InternalBlangDsl.g:3834:9: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_51);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									if (current==null) {
                    	      										current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      									}
                    	      									add(
                    	      										current,
                    	      										"declaredFormalParameters",
                    	      										lv_declaredFormalParameters_3_0,
                    	      										"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                    	      									afterParserOrEnumRuleCall();
                    	      								
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBlangDsl.g:3853:5: ( (lv_explicitSyntax_4_0= '|' ) )
            // InternalBlangDsl.g:3854:6: (lv_explicitSyntax_4_0= '|' )
            {
            // InternalBlangDsl.g:3854:6: (lv_explicitSyntax_4_0= '|' )
            // InternalBlangDsl.g:3855:7: lv_explicitSyntax_4_0= '|'
            {
            lv_explicitSyntax_4_0=(Token)match(input,27,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
              						
            }
            if ( state.backtracking==0 ) {

              							if (current==null) {
              								current = createModelElement(grammarAccess.getXShortClosureRule());
              							}
              							setWithLastConsumed(current, "explicitSyntax", true, "|");
              						
            }

            }


            }


            }


            }

            // InternalBlangDsl.g:3869:3: ( (lv_expression_5_0= ruleXExpression ) )
            // InternalBlangDsl.g:3870:4: (lv_expression_5_0= ruleXExpression )
            {
            // InternalBlangDsl.g:3870:4: (lv_expression_5_0= ruleXExpression )
            // InternalBlangDsl.g:3871:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXShortClosureRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // InternalBlangDsl.g:3892:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // InternalBlangDsl.g:3892:65: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // InternalBlangDsl.g:3893:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // InternalBlangDsl.g:3899:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3905:2: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
            // InternalBlangDsl.g:3906:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            {
            // InternalBlangDsl.g:3906:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
            // InternalBlangDsl.g:3907:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_43);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // InternalBlangDsl.g:3927:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // InternalBlangDsl.g:3927:54: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // InternalBlangDsl.g:3928:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // InternalBlangDsl.g:3934:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:3940:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // InternalBlangDsl.g:3941:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // InternalBlangDsl.g:3941:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // InternalBlangDsl.g:3942:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // InternalBlangDsl.g:3942:3: ()
            // InternalBlangDsl.g:3943:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalBlangDsl.g:3957:3: ( (lv_if_3_0= ruleXExpression ) )
            // InternalBlangDsl.g:3958:4: (lv_if_3_0= ruleXExpression )
            {
            // InternalBlangDsl.g:3958:4: (lv_if_3_0= ruleXExpression )
            // InternalBlangDsl.g:3959:5: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              					}
              					set(
              						current,
              						"if",
              						lv_if_3_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalBlangDsl.g:3980:3: ( (lv_then_5_0= ruleXExpression ) )
            // InternalBlangDsl.g:3981:4: (lv_then_5_0= ruleXExpression )
            {
            // InternalBlangDsl.g:3981:4: (lv_then_5_0= ruleXExpression )
            // InternalBlangDsl.g:3982:5: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_56);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:3999:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==68) ) {
                int LA59_1 = input.LA(2);

                if ( (synpred26_InternalBlangDsl()) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalBlangDsl.g:4000:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // InternalBlangDsl.g:4000:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // InternalBlangDsl.g:4001:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,68,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                      				
                    }

                    }

                    // InternalBlangDsl.g:4007:4: ( (lv_else_7_0= ruleXExpression ) )
                    // InternalBlangDsl.g:4008:5: (lv_else_7_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:4008:5: (lv_else_7_0= ruleXExpression )
                    // InternalBlangDsl.g:4009:6: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_7_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // InternalBlangDsl.g:4031:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // InternalBlangDsl.g:4031:58: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // InternalBlangDsl.g:4032:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // InternalBlangDsl.g:4038:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_switch_5_0 = null;

        EObject lv_declaredParam_7_0 = null;

        EObject lv_switch_9_0 = null;

        EObject lv_cases_11_0 = null;

        EObject lv_default_14_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4044:2: ( ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
            // InternalBlangDsl.g:4045:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            {
            // InternalBlangDsl.g:4045:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
            // InternalBlangDsl.g:4046:3: () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
            {
            // InternalBlangDsl.g:4046:3: ()
            // InternalBlangDsl.g:4047:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
              		
            }
            // InternalBlangDsl.g:4057:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalBlangDsl.g:4058:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    {
                    // InternalBlangDsl.g:4058:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
                    // InternalBlangDsl.g:4059:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')'
                    {
                    // InternalBlangDsl.g:4059:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
                    // InternalBlangDsl.g:4060:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    {
                    // InternalBlangDsl.g:4070:6: (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
                    // InternalBlangDsl.g:4071:7: otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0());
                      						
                    }
                    // InternalBlangDsl.g:4075:7: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
                    // InternalBlangDsl.g:4076:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    {
                    // InternalBlangDsl.g:4076:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    // InternalBlangDsl.g:4077:9: lv_declaredParam_3_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      									newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0());
                      								
                    }
                    pushFollow(FOLLOW_58);
                    lv_declaredParam_3_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      									if (current==null) {
                      										current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      									}
                      									set(
                      										current,
                      										"declaredParam",
                      										lv_declaredParam_3_0,
                      										"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                      									afterParserOrEnumRuleCall();
                      								
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,70,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2());
                      						
                    }

                    }


                    }

                    // InternalBlangDsl.g:4100:5: ( (lv_switch_5_0= ruleXExpression ) )
                    // InternalBlangDsl.g:4101:6: (lv_switch_5_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:4101:6: (lv_switch_5_0= ruleXExpression )
                    // InternalBlangDsl.g:4102:7: lv_switch_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_43);
                    lv_switch_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      							}
                      							set(
                      								current,
                      								"switch",
                      								lv_switch_5_0,
                      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,25,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:4125:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    {
                    // InternalBlangDsl.g:4125:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    // InternalBlangDsl.g:4126:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) )
                    {
                    // InternalBlangDsl.g:4126:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?
                    int alt60=2;
                    alt60 = dfa60.predict(input);
                    switch (alt60) {
                        case 1 :
                            // InternalBlangDsl.g:4127:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            {
                            // InternalBlangDsl.g:4136:6: ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
                            // InternalBlangDsl.g:4137:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':'
                            {
                            // InternalBlangDsl.g:4137:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) )
                            // InternalBlangDsl.g:4138:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            {
                            // InternalBlangDsl.g:4138:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            // InternalBlangDsl.g:4139:9: lv_declaredParam_7_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0());
                              								
                            }
                            pushFollow(FOLLOW_58);
                            lv_declaredParam_7_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                              									}
                              									set(
                              										current,
                              										"declaredParam",
                              										lv_declaredParam_7_0,
                              										"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            otherlv_8=(Token)match(input,70,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1());
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalBlangDsl.g:4162:5: ( (lv_switch_9_0= ruleXExpression ) )
                    // InternalBlangDsl.g:4163:6: (lv_switch_9_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:4163:6: (lv_switch_9_0= ruleXExpression )
                    // InternalBlangDsl.g:4164:7: lv_switch_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_6);
                    lv_switch_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      							}
                      							set(
                      								current,
                      								"switch",
                      								lv_switch_9_0,
                      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalBlangDsl.g:4187:3: ( (lv_cases_11_0= ruleXCasePart ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID||(LA62_0>=23 && LA62_0<=24)||LA62_0==47||LA62_0==70||LA62_0==72) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBlangDsl.g:4188:4: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // InternalBlangDsl.g:4188:4: (lv_cases_11_0= ruleXCasePart )
            	    // InternalBlangDsl.g:4189:5: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_cases_11_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"cases",
            	      						lv_cases_11_0,
            	      						"org.eclipse.xtext.xbase.Xbase.XCasePart");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            // InternalBlangDsl.g:4206:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==71) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalBlangDsl.g:4207:4: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
                    {
                    otherlv_12=(Token)match(input,71,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
                      			
                    }
                    otherlv_13=(Token)match(input,70,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
                      			
                    }
                    // InternalBlangDsl.g:4215:4: ( (lv_default_14_0= ruleXExpression ) )
                    // InternalBlangDsl.g:4216:5: (lv_default_14_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:4216:5: (lv_default_14_0= ruleXExpression )
                    // InternalBlangDsl.g:4217:6: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0());
                      					
                    }
                    pushFollow(FOLLOW_9);
                    lv_default_14_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_14_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_15, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXCasePart"
    // InternalBlangDsl.g:4243:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // InternalBlangDsl.g:4243:50: (iv_ruleXCasePart= ruleXCasePart EOF )
            // InternalBlangDsl.g:4244:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // InternalBlangDsl.g:4250:1: ruleXCasePart returns [EObject current=null] : ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_fallThrough_6_0=null;
        EObject lv_typeGuard_1_0 = null;

        EObject lv_case_3_0 = null;

        EObject lv_then_5_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4256:2: ( ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) )
            // InternalBlangDsl.g:4257:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            {
            // InternalBlangDsl.g:4257:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
            // InternalBlangDsl.g:4258:3: () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            {
            // InternalBlangDsl.g:4258:3: ()
            // InternalBlangDsl.g:4259:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXCasePartAccess().getXCasePartAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:4265:3: ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID||LA64_0==23||LA64_0==47) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalBlangDsl.g:4266:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    {
                    // InternalBlangDsl.g:4266:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    // InternalBlangDsl.g:4267:5: lv_typeGuard_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_60);
                    lv_typeGuard_1_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      					}
                      					set(
                      						current,
                      						"typeGuard",
                      						lv_typeGuard_1_0,
                      						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBlangDsl.g:4284:3: (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==72) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalBlangDsl.g:4285:4: otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) )
                    {
                    otherlv_2=(Token)match(input,72,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXCasePartAccess().getCaseKeyword_2_0());
                      			
                    }
                    // InternalBlangDsl.g:4289:4: ( (lv_case_3_0= ruleXExpression ) )
                    // InternalBlangDsl.g:4290:5: (lv_case_3_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:4290:5: (lv_case_3_0= ruleXExpression )
                    // InternalBlangDsl.g:4291:6: lv_case_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_61);
                    lv_case_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      						}
                      						set(
                      							current,
                      							"case",
                      							lv_case_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBlangDsl.g:4309:3: ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==70) ) {
                alt66=1;
            }
            else if ( (LA66_0==24) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalBlangDsl.g:4310:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    {
                    // InternalBlangDsl.g:4310:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
                    // InternalBlangDsl.g:4311:5: otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) )
                    {
                    otherlv_4=(Token)match(input,70,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getXCasePartAccess().getColonKeyword_3_0_0());
                      				
                    }
                    // InternalBlangDsl.g:4315:5: ( (lv_then_5_0= ruleXExpression ) )
                    // InternalBlangDsl.g:4316:6: (lv_then_5_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:4316:6: (lv_then_5_0= ruleXExpression )
                    // InternalBlangDsl.g:4317:7: lv_then_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_then_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      							}
                      							set(
                      								current,
                      								"then",
                      								lv_then_5_0,
                      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:4336:4: ( (lv_fallThrough_6_0= ',' ) )
                    {
                    // InternalBlangDsl.g:4336:4: ( (lv_fallThrough_6_0= ',' ) )
                    // InternalBlangDsl.g:4337:5: (lv_fallThrough_6_0= ',' )
                    {
                    // InternalBlangDsl.g:4337:5: (lv_fallThrough_6_0= ',' )
                    // InternalBlangDsl.g:4338:6: lv_fallThrough_6_0= ','
                    {
                    lv_fallThrough_6_0=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_fallThrough_6_0, grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXCasePartRule());
                      						}
                      						setWithLastConsumed(current, "fallThrough", true, ",");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // InternalBlangDsl.g:4355:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // InternalBlangDsl.g:4355:59: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // InternalBlangDsl.g:4356:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // InternalBlangDsl.g:4362:1: ruleXForLoopExpression returns [EObject current=null] : ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4368:2: ( ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // InternalBlangDsl.g:4369:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // InternalBlangDsl.g:4369:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // InternalBlangDsl.g:4370:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // InternalBlangDsl.g:4370:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
            // InternalBlangDsl.g:4371:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            {
            // InternalBlangDsl.g:4384:4: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
            // InternalBlangDsl.g:4385:5: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
            {
            // InternalBlangDsl.g:4385:5: ()
            // InternalBlangDsl.g:4386:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,73,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1());
              				
            }
            otherlv_2=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
              				
            }
            // InternalBlangDsl.g:4400:5: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // InternalBlangDsl.g:4401:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // InternalBlangDsl.g:4401:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // InternalBlangDsl.g:4402:7: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              							newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0());
              						
            }
            pushFollow(FOLLOW_58);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							if (current==null) {
              								current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              							}
              							set(
              								current,
              								"declaredParam",
              								lv_declaredParam_3_0,
              								"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
              							afterParserOrEnumRuleCall();
              						
            }

            }


            }

            otherlv_4=(Token)match(input,70,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4());
              				
            }

            }


            }

            // InternalBlangDsl.g:4425:3: ( (lv_forExpression_5_0= ruleXExpression ) )
            // InternalBlangDsl.g:4426:4: (lv_forExpression_5_0= ruleXExpression )
            {
            // InternalBlangDsl.g:4426:4: (lv_forExpression_5_0= ruleXExpression )
            // InternalBlangDsl.g:4427:5: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              					}
              					set(
              						current,
              						"forExpression",
              						lv_forExpression_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
              		
            }
            // InternalBlangDsl.g:4448:3: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // InternalBlangDsl.g:4449:4: (lv_eachExpression_7_0= ruleXExpression )
            {
            // InternalBlangDsl.g:4449:4: (lv_eachExpression_7_0= ruleXExpression )
            // InternalBlangDsl.g:4450:5: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              					}
              					set(
              						current,
              						"eachExpression",
              						lv_eachExpression_7_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXBasicForLoopExpression"
    // InternalBlangDsl.g:4471:1: entryRuleXBasicForLoopExpression returns [EObject current=null] : iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
    public final EObject entryRuleXBasicForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBasicForLoopExpression = null;


        try {
            // InternalBlangDsl.g:4471:64: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
            // InternalBlangDsl.g:4472:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBasicForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBasicForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBasicForLoopExpression"


    // $ANTLR start "ruleXBasicForLoopExpression"
    // InternalBlangDsl.g:4478:1: ruleXBasicForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) ;
    public final EObject ruleXBasicForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_initExpressions_3_0 = null;

        EObject lv_initExpressions_5_0 = null;

        EObject lv_expression_7_0 = null;

        EObject lv_updateExpressions_9_0 = null;

        EObject lv_updateExpressions_11_0 = null;

        EObject lv_eachExpression_13_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4484:2: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) )
            // InternalBlangDsl.g:4485:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            {
            // InternalBlangDsl.g:4485:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            // InternalBlangDsl.g:4486:3: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) )
            {
            // InternalBlangDsl.g:4486:3: ()
            // InternalBlangDsl.g:4487:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,73,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,23,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalBlangDsl.g:4501:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=RULE_STRING && LA68_0<=RULE_ID)||LA68_0==15||LA68_0==23||LA68_0==34||(LA68_0>=50 && LA68_0<=51)||LA68_0==56||(LA68_0>=63 && LA68_0<=64)||LA68_0==67||LA68_0==69||(LA68_0>=73 && LA68_0<=90)||LA68_0==92) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalBlangDsl.g:4502:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    {
                    // InternalBlangDsl.g:4502:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
                    // InternalBlangDsl.g:4503:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    {
                    // InternalBlangDsl.g:4503:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    // InternalBlangDsl.g:4504:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_63);
                    lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      						}
                      						add(
                      							current,
                      							"initExpressions",
                      							lv_initExpressions_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:4521:4: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==24) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalBlangDsl.g:4522:5: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    {
                    	    otherlv_4=(Token)match(input,24,FOLLOW_64); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalBlangDsl.g:4526:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    // InternalBlangDsl.g:4527:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    {
                    	    // InternalBlangDsl.g:4527:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    // InternalBlangDsl.g:4528:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_63);
                    	    lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"initExpressions",
                    	      								lv_initExpressions_5_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,66,FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
              		
            }
            // InternalBlangDsl.g:4551:3: ( (lv_expression_7_0= ruleXExpression ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_ID)||LA69_0==15||LA69_0==23||LA69_0==34||(LA69_0>=50 && LA69_0<=51)||LA69_0==56||(LA69_0>=63 && LA69_0<=64)||LA69_0==67||LA69_0==69||(LA69_0>=73 && LA69_0<=75)||(LA69_0>=78 && LA69_0<=90)||LA69_0==92) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalBlangDsl.g:4552:4: (lv_expression_7_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:4552:4: (lv_expression_7_0= ruleXExpression )
                    // InternalBlangDsl.g:4553:5: lv_expression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_66);
                    lv_expression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_7_0,
                      						"org.eclipse.xtext.xbase.Xbase.XExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,66,FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6());
              		
            }
            // InternalBlangDsl.g:4574:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_STRING && LA71_0<=RULE_ID)||LA71_0==15||LA71_0==23||LA71_0==34||(LA71_0>=50 && LA71_0<=51)||LA71_0==56||(LA71_0>=63 && LA71_0<=64)||LA71_0==67||LA71_0==69||(LA71_0>=73 && LA71_0<=75)||(LA71_0>=78 && LA71_0<=90)||LA71_0==92) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalBlangDsl.g:4575:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    {
                    // InternalBlangDsl.g:4575:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
                    // InternalBlangDsl.g:4576:5: (lv_updateExpressions_9_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:4576:5: (lv_updateExpressions_9_0= ruleXExpression )
                    // InternalBlangDsl.g:4577:6: lv_updateExpressions_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_updateExpressions_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      						}
                      						add(
                      							current,
                      							"updateExpressions",
                      							lv_updateExpressions_9_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:4594:4: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==24) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalBlangDsl.g:4595:5: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    {
                    	    otherlv_10=(Token)match(input,24,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
                    	      				
                    	    }
                    	    // InternalBlangDsl.g:4599:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    // InternalBlangDsl.g:4600:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    {
                    	    // InternalBlangDsl.g:4600:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    // InternalBlangDsl.g:4601:7: lv_updateExpressions_11_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    lv_updateExpressions_11_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"updateExpressions",
                    	      								lv_updateExpressions_11_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
              		
            }
            // InternalBlangDsl.g:4624:3: ( (lv_eachExpression_13_0= ruleXExpression ) )
            // InternalBlangDsl.g:4625:4: (lv_eachExpression_13_0= ruleXExpression )
            {
            // InternalBlangDsl.g:4625:4: (lv_eachExpression_13_0= ruleXExpression )
            // InternalBlangDsl.g:4626:5: lv_eachExpression_13_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_9_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_13_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
              					}
              					set(
              						current,
              						"eachExpression",
              						lv_eachExpression_13_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBasicForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // InternalBlangDsl.g:4647:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // InternalBlangDsl.g:4647:57: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // InternalBlangDsl.g:4648:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // InternalBlangDsl.g:4654:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4660:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
            // InternalBlangDsl.g:4661:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // InternalBlangDsl.g:4661:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
            // InternalBlangDsl.g:4662:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
            {
            // InternalBlangDsl.g:4662:3: ()
            // InternalBlangDsl.g:4663:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,74,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalBlangDsl.g:4677:3: ( (lv_predicate_3_0= ruleXExpression ) )
            // InternalBlangDsl.g:4678:4: (lv_predicate_3_0= ruleXExpression )
            {
            // InternalBlangDsl.g:4678:4: (lv_predicate_3_0= ruleXExpression )
            // InternalBlangDsl.g:4679:5: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              					}
              					set(
              						current,
              						"predicate",
              						lv_predicate_3_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalBlangDsl.g:4700:3: ( (lv_body_5_0= ruleXExpression ) )
            // InternalBlangDsl.g:4701:4: (lv_body_5_0= ruleXExpression )
            {
            // InternalBlangDsl.g:4701:4: (lv_body_5_0= ruleXExpression )
            // InternalBlangDsl.g:4702:5: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // InternalBlangDsl.g:4723:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // InternalBlangDsl.g:4723:59: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // InternalBlangDsl.g:4724:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // InternalBlangDsl.g:4730:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_2_0 = null;

        EObject lv_predicate_5_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4736:2: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
            // InternalBlangDsl.g:4737:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            {
            // InternalBlangDsl.g:4737:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
            // InternalBlangDsl.g:4738:3: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
            {
            // InternalBlangDsl.g:4738:3: ()
            // InternalBlangDsl.g:4739:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,75,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
              		
            }
            // InternalBlangDsl.g:4749:3: ( (lv_body_2_0= ruleXExpression ) )
            // InternalBlangDsl.g:4750:4: (lv_body_2_0= ruleXExpression )
            {
            // InternalBlangDsl.g:4750:4: (lv_body_2_0= ruleXExpression )
            // InternalBlangDsl.g:4751:5: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_68);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_2_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,74,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalBlangDsl.g:4776:3: ( (lv_predicate_5_0= ruleXExpression ) )
            // InternalBlangDsl.g:4777:4: (lv_predicate_5_0= ruleXExpression )
            {
            // InternalBlangDsl.g:4777:4: (lv_predicate_5_0= ruleXExpression )
            // InternalBlangDsl.g:4778:5: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              					}
              					set(
              						current,
              						"predicate",
              						lv_predicate_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXBlockExpression"
    // InternalBlangDsl.g:4803:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // InternalBlangDsl.g:4803:57: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // InternalBlangDsl.g:4804:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // InternalBlangDsl.g:4810:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4816:2: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
            // InternalBlangDsl.g:4817:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            {
            // InternalBlangDsl.g:4817:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
            // InternalBlangDsl.g:4818:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
            {
            // InternalBlangDsl.g:4818:3: ()
            // InternalBlangDsl.g:4819:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,15,FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalBlangDsl.g:4829:3: ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( ((LA73_0>=RULE_STRING && LA73_0<=RULE_ID)||LA73_0==15||LA73_0==23||LA73_0==34||(LA73_0>=50 && LA73_0<=51)||LA73_0==56||(LA73_0>=63 && LA73_0<=64)||LA73_0==67||LA73_0==69||(LA73_0>=73 && LA73_0<=90)||LA73_0==92) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalBlangDsl.g:4830:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
            	    {
            	    // InternalBlangDsl.g:4830:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) )
            	    // InternalBlangDsl.g:4831:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // InternalBlangDsl.g:4831:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    // InternalBlangDsl.g:4832:6: lv_expressions_2_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_70);
            	    lv_expressions_2_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_2_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalBlangDsl.g:4849:4: (otherlv_3= ';' )?
            	    int alt72=2;
            	    int LA72_0 = input.LA(1);

            	    if ( (LA72_0==66) ) {
            	        alt72=1;
            	    }
            	    switch (alt72) {
            	        case 1 :
            	            // InternalBlangDsl.g:4850:5: otherlv_3= ';'
            	            {
            	            otherlv_3=(Token)match(input,66,FOLLOW_69); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXExpressionOrVarDeclaration"
    // InternalBlangDsl.g:4864:1: entryRuleXExpressionOrVarDeclaration returns [EObject current=null] : iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
    public final EObject entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionOrVarDeclaration = null;


        try {
            // InternalBlangDsl.g:4864:68: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
            // InternalBlangDsl.g:4865:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionOrVarDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXExpressionOrVarDeclaration"


    // $ANTLR start "ruleXExpressionOrVarDeclaration"
    // InternalBlangDsl.g:4871:1: ruleXExpressionOrVarDeclaration returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4877:2: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // InternalBlangDsl.g:4878:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // InternalBlangDsl.g:4878:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=76 && LA74_0<=77)) ) {
                alt74=1;
            }
            else if ( ((LA74_0>=RULE_STRING && LA74_0<=RULE_ID)||LA74_0==15||LA74_0==23||LA74_0==34||(LA74_0>=50 && LA74_0<=51)||LA74_0==56||(LA74_0>=63 && LA74_0<=64)||LA74_0==67||LA74_0==69||(LA74_0>=73 && LA74_0<=75)||(LA74_0>=78 && LA74_0<=90)||LA74_0==92) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalBlangDsl.g:4879:3: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XVariableDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:4888:3: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXExpressionOrVarDeclaration"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // InternalBlangDsl.g:4900:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // InternalBlangDsl.g:4900:61: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // InternalBlangDsl.g:4901:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // InternalBlangDsl.g:4907:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_right_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:4913:2: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // InternalBlangDsl.g:4914:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // InternalBlangDsl.g:4914:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
            // InternalBlangDsl.g:4915:3: () ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // InternalBlangDsl.g:4915:3: ()
            // InternalBlangDsl.g:4916:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:4922:3: ( ( (lv_writeable_1_0= 'var' ) ) | otherlv_2= 'val' )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==76) ) {
                alt75=1;
            }
            else if ( (LA75_0==77) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalBlangDsl.g:4923:4: ( (lv_writeable_1_0= 'var' ) )
                    {
                    // InternalBlangDsl.g:4923:4: ( (lv_writeable_1_0= 'var' ) )
                    // InternalBlangDsl.g:4924:5: (lv_writeable_1_0= 'var' )
                    {
                    // InternalBlangDsl.g:4924:5: (lv_writeable_1_0= 'var' )
                    // InternalBlangDsl.g:4925:6: lv_writeable_1_0= 'var'
                    {
                    lv_writeable_1_0=(Token)match(input,76,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "writeable", true, "var");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:4938:4: otherlv_2= 'val'
                    {
                    otherlv_2=(Token)match(input,77,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalBlangDsl.g:4943:3: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                int LA76_1 = input.LA(2);

                if ( (synpred30_InternalBlangDsl()) ) {
                    alt76=1;
                }
                else if ( (true) ) {
                    alt76=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA76_0==23) && (synpred30_InternalBlangDsl())) {
                alt76=1;
            }
            else if ( (LA76_0==47) && (synpred30_InternalBlangDsl())) {
                alt76=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalBlangDsl.g:4944:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // InternalBlangDsl.g:4944:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // InternalBlangDsl.g:4945:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // InternalBlangDsl.g:4958:5: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // InternalBlangDsl.g:4959:6: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // InternalBlangDsl.g:4959:6: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // InternalBlangDsl.g:4960:7: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // InternalBlangDsl.g:4960:7: (lv_type_3_0= ruleJvmTypeReference )
                    // InternalBlangDsl.g:4961:8: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0());
                      							
                    }
                    pushFollow(FOLLOW_3);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"type",
                      									lv_type_3_0,
                      									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }

                    // InternalBlangDsl.g:4978:6: ( (lv_name_4_0= ruleValidID ) )
                    // InternalBlangDsl.g:4979:7: (lv_name_4_0= ruleValidID )
                    {
                    // InternalBlangDsl.g:4979:7: (lv_name_4_0= ruleValidID )
                    // InternalBlangDsl.g:4980:8: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0());
                      							
                    }
                    pushFollow(FOLLOW_71);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"name",
                      									lv_name_4_0,
                      									"org.eclipse.xtext.xbase.Xtype.ValidID");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:5000:4: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // InternalBlangDsl.g:5000:4: ( (lv_name_5_0= ruleValidID ) )
                    // InternalBlangDsl.g:5001:5: (lv_name_5_0= ruleValidID )
                    {
                    // InternalBlangDsl.g:5001:5: (lv_name_5_0= ruleValidID )
                    // InternalBlangDsl.g:5002:6: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_71);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_5_0,
                      							"org.eclipse.xtext.xbase.Xtype.ValidID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBlangDsl.g:5020:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==20) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalBlangDsl.g:5021:4: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalBlangDsl.g:5025:4: ( (lv_right_7_0= ruleXExpression ) )
                    // InternalBlangDsl.g:5026:5: (lv_right_7_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:5026:5: (lv_right_7_0= ruleXExpression )
                    // InternalBlangDsl.g:5027:6: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_7_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // InternalBlangDsl.g:5049:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // InternalBlangDsl.g:5049:59: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // InternalBlangDsl.g:5050:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // InternalBlangDsl.g:5056:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5062:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalBlangDsl.g:5063:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalBlangDsl.g:5063:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // InternalBlangDsl.g:5064:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalBlangDsl.g:5064:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                int LA78_1 = input.LA(2);

                if ( (LA78_1==RULE_ID||LA78_1==34||LA78_1==60||LA78_1==64) ) {
                    alt78=1;
                }
            }
            else if ( (LA78_0==23||LA78_0==47) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalBlangDsl.g:5065:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // InternalBlangDsl.g:5065:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // InternalBlangDsl.g:5066:5: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_3);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
                      					}
                      					set(
                      						current,
                      						"parameterType",
                      						lv_parameterType_0_0,
                      						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBlangDsl.g:5083:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalBlangDsl.g:5084:4: (lv_name_1_0= ruleValidID )
            {
            // InternalBlangDsl.g:5084:4: (lv_name_1_0= ruleValidID )
            // InternalBlangDsl.g:5085:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // InternalBlangDsl.g:5106:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // InternalBlangDsl.g:5106:63: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // InternalBlangDsl.g:5107:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // InternalBlangDsl.g:5113:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5119:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalBlangDsl.g:5120:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalBlangDsl.g:5120:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // InternalBlangDsl.g:5121:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalBlangDsl.g:5121:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:5122:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:5122:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:5123:5: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              					}
              					set(
              						current,
              						"parameterType",
              						lv_parameterType_0_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:5140:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalBlangDsl.g:5141:4: (lv_name_1_0= ruleValidID )
            {
            // InternalBlangDsl.g:5141:4: (lv_name_1_0= ruleValidID )
            // InternalBlangDsl.g:5142:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // InternalBlangDsl.g:5163:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // InternalBlangDsl.g:5163:53: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // InternalBlangDsl.g:5164:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // InternalBlangDsl.g:5170:1: ruleXFeatureCall returns [EObject current=null] : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_explicitOperationCall_7_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_featureCallArguments_8_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_11_0 = null;

        EObject lv_featureCallArguments_13_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5176:2: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) )
            // InternalBlangDsl.g:5177:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            {
            // InternalBlangDsl.g:5177:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            // InternalBlangDsl.g:5178:3: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            {
            // InternalBlangDsl.g:5178:3: ()
            // InternalBlangDsl.g:5179:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:5185:3: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==34) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalBlangDsl.g:5186:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalBlangDsl.g:5190:4: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
                    // InternalBlangDsl.g:5191:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalBlangDsl.g:5191:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    // InternalBlangDsl.g:5192:6: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
                    lv_typeArguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      						}
                      						add(
                      							current,
                      							"typeArguments",
                      							lv_typeArguments_2_0,
                      							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:5209:4: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==24) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalBlangDsl.g:5210:5: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,24,FOLLOW_39); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalBlangDsl.g:5214:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalBlangDsl.g:5215:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalBlangDsl.g:5215:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    // InternalBlangDsl.g:5216:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_40);
                    	    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"typeArguments",
                    	      								lv_typeArguments_4_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,35,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
                      			
                    }

                    }
                    break;

            }

            // InternalBlangDsl.g:5239:3: ( ( ruleIdOrSuper ) )
            // InternalBlangDsl.g:5240:4: ( ruleIdOrSuper )
            {
            // InternalBlangDsl.g:5240:4: ( ruleIdOrSuper )
            // InternalBlangDsl.g:5241:5: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXFeatureCallRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_72);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:5255:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
            int alt83=2;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // InternalBlangDsl.g:5256:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
                    {
                    // InternalBlangDsl.g:5256:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
                    // InternalBlangDsl.g:5257:5: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
                    {
                    // InternalBlangDsl.g:5261:5: (lv_explicitOperationCall_7_0= '(' )
                    // InternalBlangDsl.g:5262:6: lv_explicitOperationCall_7_0= '('
                    {
                    lv_explicitOperationCall_7_0=(Token)match(input,23,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_explicitOperationCall_7_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXFeatureCallRule());
                      						}
                      						setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:5274:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
                    int alt82=3;
                    alt82 = dfa82.predict(input);
                    switch (alt82) {
                        case 1 :
                            // InternalBlangDsl.g:5275:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            {
                            // InternalBlangDsl.g:5275:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            // InternalBlangDsl.g:5276:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
                            {
                            // InternalBlangDsl.g:5301:6: (lv_featureCallArguments_8_0= ruleXShortClosure )
                            // InternalBlangDsl.g:5302:7: lv_featureCallArguments_8_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_43);
                            lv_featureCallArguments_8_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              							}
                              							add(
                              								current,
                              								"featureCallArguments",
                              								lv_featureCallArguments_8_0,
                              								"org.eclipse.xtext.xbase.Xbase.XShortClosure");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBlangDsl.g:5320:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            {
                            // InternalBlangDsl.g:5320:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            // InternalBlangDsl.g:5321:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            {
                            // InternalBlangDsl.g:5321:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            // InternalBlangDsl.g:5322:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            {
                            // InternalBlangDsl.g:5322:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            // InternalBlangDsl.g:5323:8: lv_featureCallArguments_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_16);
                            lv_featureCallArguments_9_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              								}
                              								add(
                              									current,
                              									"featureCallArguments",
                              									lv_featureCallArguments_9_0,
                              									"org.eclipse.xtext.xbase.Xbase.XExpression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalBlangDsl.g:5340:6: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            loop81:
                            do {
                                int alt81=2;
                                int LA81_0 = input.LA(1);

                                if ( (LA81_0==24) ) {
                                    alt81=1;
                                }


                                switch (alt81) {
                            	case 1 :
                            	    // InternalBlangDsl.g:5341:7: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    {
                            	    otherlv_10=(Token)match(input,24,FOLLOW_13); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
                            	      						
                            	    }
                            	    // InternalBlangDsl.g:5345:7: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    // InternalBlangDsl.g:5346:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    {
                            	    // InternalBlangDsl.g:5346:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    // InternalBlangDsl.g:5347:9: lv_featureCallArguments_11_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_16);
                            	    lv_featureCallArguments_11_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"featureCallArguments",
                            	      										lv_featureCallArguments_11_0,
                            	      										"org.eclipse.xtext.xbase.Xbase.XExpression");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop81;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,25,FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalBlangDsl.g:5372:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            int alt84=2;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // InternalBlangDsl.g:5373:4: ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure )
                    {
                    // InternalBlangDsl.g:5379:4: (lv_featureCallArguments_13_0= ruleXClosure )
                    // InternalBlangDsl.g:5380:5: lv_featureCallArguments_13_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_featureCallArguments_13_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      					}
                      					add(
                      						current,
                      						"featureCallArguments",
                      						lv_featureCallArguments_13_0,
                      						"org.eclipse.xtext.xbase.Xbase.XClosure");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleFeatureCallID"
    // InternalBlangDsl.g:5401:1: entryRuleFeatureCallID returns [String current=null] : iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
    public final String entryRuleFeatureCallID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCallID = null;


        try {
            // InternalBlangDsl.g:5401:53: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
            // InternalBlangDsl.g:5402:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCallID=ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCallID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCallID"


    // $ANTLR start "ruleFeatureCallID"
    // InternalBlangDsl.g:5408:1: ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5414:2: ( (this_ValidID_0= ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' ) )
            // InternalBlangDsl.g:5415:2: (this_ValidID_0= ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' )
            {
            // InternalBlangDsl.g:5415:2: (this_ValidID_0= ruleValidID | kw= 'extends' | kw= 'static' | kw= 'import' | kw= 'extension' )
            int alt85=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt85=1;
                }
                break;
            case 78:
                {
                alt85=2;
                }
                break;
            case 79:
                {
                alt85=3;
                }
                break;
            case 80:
                {
                alt85=4;
                }
                break;
            case 81:
                {
                alt85=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalBlangDsl.g:5416:3: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFeatureCallIDAccess().getValidIDParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValidID_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ValidID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:5427:3: kw= 'extends'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtendsKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:5433:3: kw= 'static'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getStaticKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBlangDsl.g:5439:3: kw= 'import'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getImportKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBlangDsl.g:5445:3: kw= 'extension'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtensionKeyword_4());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCallID"


    // $ANTLR start "entryRuleIdOrSuper"
    // InternalBlangDsl.g:5454:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // InternalBlangDsl.g:5454:49: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // InternalBlangDsl.g:5455:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // InternalBlangDsl.g:5461:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FeatureCallID_0= ruleFeatureCallID | kw= 'super' ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FeatureCallID_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5467:2: ( (this_FeatureCallID_0= ruleFeatureCallID | kw= 'super' ) )
            // InternalBlangDsl.g:5468:2: (this_FeatureCallID_0= ruleFeatureCallID | kw= 'super' )
            {
            // InternalBlangDsl.g:5468:2: (this_FeatureCallID_0= ruleFeatureCallID | kw= 'super' )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_ID||(LA86_0>=78 && LA86_0<=81)) ) {
                alt86=1;
            }
            else if ( (LA86_0==82) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalBlangDsl.g:5469:3: this_FeatureCallID_0= ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCallID_0=ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_FeatureCallID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:5480:3: kw= 'super'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleXConstructorCall"
    // InternalBlangDsl.g:5489:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // InternalBlangDsl.g:5489:57: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // InternalBlangDsl.g:5490:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // InternalBlangDsl.g:5496:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_explicitConstructorCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;

        EObject lv_arguments_14_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5502:2: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // InternalBlangDsl.g:5503:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // InternalBlangDsl.g:5503:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // InternalBlangDsl.g:5504:3: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // InternalBlangDsl.g:5504:3: ()
            // InternalBlangDsl.g:5505:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,83,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
              		
            }
            // InternalBlangDsl.g:5515:3: ( ( ruleQualifiedName ) )
            // InternalBlangDsl.g:5516:4: ( ruleQualifiedName )
            {
            // InternalBlangDsl.g:5516:4: ( ruleQualifiedName )
            // InternalBlangDsl.g:5517:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXConstructorCallRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_74);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:5531:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
            int alt88=2;
            alt88 = dfa88.predict(input);
            switch (alt88) {
                case 1 :
                    // InternalBlangDsl.g:5532:4: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
                    {
                    // InternalBlangDsl.g:5532:4: ( ( '<' )=>otherlv_3= '<' )
                    // InternalBlangDsl.g:5533:5: ( '<' )=>otherlv_3= '<'
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                      				
                    }

                    }

                    // InternalBlangDsl.g:5539:4: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // InternalBlangDsl.g:5540:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalBlangDsl.g:5540:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // InternalBlangDsl.g:5541:6: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      						}
                      						add(
                      							current,
                      							"typeArguments",
                      							lv_typeArguments_4_0,
                      							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:5558:4: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==24) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // InternalBlangDsl.g:5559:5: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,24,FOLLOW_39); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalBlangDsl.g:5563:5: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalBlangDsl.g:5564:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalBlangDsl.g:5564:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // InternalBlangDsl.g:5565:7: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_40);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"typeArguments",
                    	      								lv_typeArguments_6_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop87;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,35,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                      			
                    }

                    }
                    break;

            }

            // InternalBlangDsl.g:5588:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalBlangDsl.g:5589:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
                    {
                    // InternalBlangDsl.g:5589:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
                    // InternalBlangDsl.g:5590:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
                    {
                    // InternalBlangDsl.g:5594:5: (lv_explicitConstructorCall_8_0= '(' )
                    // InternalBlangDsl.g:5595:6: lv_explicitConstructorCall_8_0= '('
                    {
                    lv_explicitConstructorCall_8_0=(Token)match(input,23,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_explicitConstructorCall_8_0, grammarAccess.getXConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXConstructorCallRule());
                      						}
                      						setWithLastConsumed(current, "explicitConstructorCall", true, "(");
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:5607:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt90=3;
                    alt90 = dfa90.predict(input);
                    switch (alt90) {
                        case 1 :
                            // InternalBlangDsl.g:5608:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // InternalBlangDsl.g:5608:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // InternalBlangDsl.g:5609:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // InternalBlangDsl.g:5634:6: (lv_arguments_9_0= ruleXShortClosure )
                            // InternalBlangDsl.g:5635:7: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_43);
                            lv_arguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              							}
                              							add(
                              								current,
                              								"arguments",
                              								lv_arguments_9_0,
                              								"org.eclipse.xtext.xbase.Xbase.XShortClosure");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBlangDsl.g:5653:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // InternalBlangDsl.g:5653:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // InternalBlangDsl.g:5654:6: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // InternalBlangDsl.g:5654:6: ( (lv_arguments_10_0= ruleXExpression ) )
                            // InternalBlangDsl.g:5655:7: (lv_arguments_10_0= ruleXExpression )
                            {
                            // InternalBlangDsl.g:5655:7: (lv_arguments_10_0= ruleXExpression )
                            // InternalBlangDsl.g:5656:8: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_16);
                            lv_arguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              								}
                              								add(
                              									current,
                              									"arguments",
                              									lv_arguments_10_0,
                              									"org.eclipse.xtext.xbase.Xbase.XExpression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalBlangDsl.g:5673:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop89:
                            do {
                                int alt89=2;
                                int LA89_0 = input.LA(1);

                                if ( (LA89_0==24) ) {
                                    alt89=1;
                                }


                                switch (alt89) {
                            	case 1 :
                            	    // InternalBlangDsl.g:5674:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,24,FOLLOW_13); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
                            	      						
                            	    }
                            	    // InternalBlangDsl.g:5678:7: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // InternalBlangDsl.g:5679:8: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // InternalBlangDsl.g:5679:8: (lv_arguments_12_0= ruleXExpression )
                            	    // InternalBlangDsl.g:5680:9: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_16);
                            	    lv_arguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"arguments",
                            	      										lv_arguments_12_0,
                            	      										"org.eclipse.xtext.xbase.Xbase.XExpression");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop89;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,25,FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
                      			
                    }

                    }
                    break;

            }

            // InternalBlangDsl.g:5705:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt92=2;
            alt92 = dfa92.predict(input);
            switch (alt92) {
                case 1 :
                    // InternalBlangDsl.g:5706:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // InternalBlangDsl.g:5712:4: (lv_arguments_14_0= ruleXClosure )
                    // InternalBlangDsl.g:5713:5: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      					}
                      					add(
                      						current,
                      						"arguments",
                      						lv_arguments_14_0,
                      						"org.eclipse.xtext.xbase.Xbase.XClosure");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // InternalBlangDsl.g:5734:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // InternalBlangDsl.g:5734:56: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // InternalBlangDsl.g:5735:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // InternalBlangDsl.g:5741:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:5747:2: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
            // InternalBlangDsl.g:5748:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            {
            // InternalBlangDsl.g:5748:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
            // InternalBlangDsl.g:5749:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            {
            // InternalBlangDsl.g:5749:3: ()
            // InternalBlangDsl.g:5750:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:5756:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==84) ) {
                alt93=1;
            }
            else if ( (LA93_0==85) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // InternalBlangDsl.g:5757:4: otherlv_1= 'false'
                    {
                    otherlv_1=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:5762:4: ( (lv_isTrue_2_0= 'true' ) )
                    {
                    // InternalBlangDsl.g:5762:4: ( (lv_isTrue_2_0= 'true' ) )
                    // InternalBlangDsl.g:5763:5: (lv_isTrue_2_0= 'true' )
                    {
                    // InternalBlangDsl.g:5763:5: (lv_isTrue_2_0= 'true' )
                    // InternalBlangDsl.g:5764:6: lv_isTrue_2_0= 'true'
                    {
                    lv_isTrue_2_0=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "isTrue", true, "true");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // InternalBlangDsl.g:5781:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // InternalBlangDsl.g:5781:53: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // InternalBlangDsl.g:5782:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // InternalBlangDsl.g:5788:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:5794:2: ( ( () otherlv_1= 'null' ) )
            // InternalBlangDsl.g:5795:2: ( () otherlv_1= 'null' )
            {
            // InternalBlangDsl.g:5795:2: ( () otherlv_1= 'null' )
            // InternalBlangDsl.g:5796:3: () otherlv_1= 'null'
            {
            // InternalBlangDsl.g:5796:3: ()
            // InternalBlangDsl.g:5797:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXNumberLiteral"
    // InternalBlangDsl.g:5811:1: entryRuleXNumberLiteral returns [EObject current=null] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final EObject entryRuleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNumberLiteral = null;


        try {
            // InternalBlangDsl.g:5811:55: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // InternalBlangDsl.g:5812:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // InternalBlangDsl.g:5818:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject ruleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5824:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // InternalBlangDsl.g:5825:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // InternalBlangDsl.g:5825:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // InternalBlangDsl.g:5826:3: () ( (lv_value_1_0= ruleNumber ) )
            {
            // InternalBlangDsl.g:5826:3: ()
            // InternalBlangDsl.g:5827:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:5833:3: ( (lv_value_1_0= ruleNumber ) )
            // InternalBlangDsl.g:5834:4: (lv_value_1_0= ruleNumber )
            {
            // InternalBlangDsl.g:5834:4: (lv_value_1_0= ruleNumber )
            // InternalBlangDsl.g:5835:5: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.xbase.Xbase.Number");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // InternalBlangDsl.g:5856:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // InternalBlangDsl.g:5856:55: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // InternalBlangDsl.g:5857:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // InternalBlangDsl.g:5863:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:5869:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalBlangDsl.g:5870:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalBlangDsl.g:5870:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalBlangDsl.g:5871:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalBlangDsl.g:5871:3: ()
            // InternalBlangDsl.g:5872:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalBlangDsl.g:5878:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalBlangDsl.g:5879:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalBlangDsl.g:5879:4: (lv_value_1_0= RULE_STRING )
            // InternalBlangDsl.g:5880:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXStringLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.xbase.Xtype.STRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // InternalBlangDsl.g:5900:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // InternalBlangDsl.g:5900:53: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // InternalBlangDsl.g:5901:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // InternalBlangDsl.g:5907:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_arrayDimensions_4_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5913:2: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) )
            // InternalBlangDsl.g:5914:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            {
            // InternalBlangDsl.g:5914:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
            // InternalBlangDsl.g:5915:3: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')'
            {
            // InternalBlangDsl.g:5915:3: ()
            // InternalBlangDsl.g:5916:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,87,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,23,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalBlangDsl.g:5930:3: ( ( ruleQualifiedName ) )
            // InternalBlangDsl.g:5931:4: ( ruleQualifiedName )
            {
            // InternalBlangDsl.g:5931:4: ( ruleQualifiedName )
            // InternalBlangDsl.g:5932:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXTypeLiteralRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0());
              				
            }
            pushFollow(FOLLOW_75);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:5946:3: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==64) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalBlangDsl.g:5947:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    {
            	    // InternalBlangDsl.g:5947:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    // InternalBlangDsl.g:5948:5: lv_arrayDimensions_4_0= ruleArrayBrackets
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_75);
            	    lv_arrayDimensions_4_0=ruleArrayBrackets();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getXTypeLiteralRule());
            	      					}
            	      					add(
            	      						current,
            	      						"arrayDimensions",
            	      						lv_arrayDimensions_4_0,
            	      						"org.eclipse.xtext.xbase.Xtype.ArrayBrackets");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // InternalBlangDsl.g:5973:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // InternalBlangDsl.g:5973:57: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // InternalBlangDsl.g:5974:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // InternalBlangDsl.g:5980:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:5986:2: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // InternalBlangDsl.g:5987:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // InternalBlangDsl.g:5987:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
            // InternalBlangDsl.g:5988:3: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
            {
            // InternalBlangDsl.g:5988:3: ()
            // InternalBlangDsl.g:5989:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,88,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
              		
            }
            // InternalBlangDsl.g:5999:3: ( (lv_expression_2_0= ruleXExpression ) )
            // InternalBlangDsl.g:6000:4: (lv_expression_2_0= ruleXExpression )
            {
            // InternalBlangDsl.g:6000:4: (lv_expression_2_0= ruleXExpression )
            // InternalBlangDsl.g:6001:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // InternalBlangDsl.g:6022:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // InternalBlangDsl.g:6022:58: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // InternalBlangDsl.g:6023:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // InternalBlangDsl.g:6029:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6035:2: ( ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // InternalBlangDsl.g:6036:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // InternalBlangDsl.g:6036:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            // InternalBlangDsl.g:6037:3: () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // InternalBlangDsl.g:6037:3: ()
            // InternalBlangDsl.g:6038:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,89,FOLLOW_76); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
              		
            }
            // InternalBlangDsl.g:6048:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt95=2;
            alt95 = dfa95.predict(input);
            switch (alt95) {
                case 1 :
                    // InternalBlangDsl.g:6049:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:6050:4: (lv_expression_2_0= ruleXExpression )
                    // InternalBlangDsl.g:6051:5: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_2_0,
                      						"org.eclipse.xtext.xbase.Xbase.XExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // InternalBlangDsl.g:6072:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // InternalBlangDsl.g:6072:67: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // InternalBlangDsl.g:6073:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // InternalBlangDsl.g:6079:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_2_0 = null;

        EObject lv_catchClauses_3_0 = null;

        EObject lv_finallyExpression_5_0 = null;

        EObject lv_finallyExpression_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6085:2: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // InternalBlangDsl.g:6086:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // InternalBlangDsl.g:6086:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // InternalBlangDsl.g:6087:3: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // InternalBlangDsl.g:6087:3: ()
            // InternalBlangDsl.g:6088:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,90,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
              		
            }
            // InternalBlangDsl.g:6098:3: ( (lv_expression_2_0= ruleXExpression ) )
            // InternalBlangDsl.g:6099:4: (lv_expression_2_0= ruleXExpression )
            {
            // InternalBlangDsl.g:6099:4: (lv_expression_2_0= ruleXExpression )
            // InternalBlangDsl.g:6100:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_77);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:6117:3: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==93) ) {
                alt98=1;
            }
            else if ( (LA98_0==91) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // InternalBlangDsl.g:6118:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // InternalBlangDsl.g:6118:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // InternalBlangDsl.g:6119:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // InternalBlangDsl.g:6119:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt96=0;
                    loop96:
                    do {
                        int alt96=2;
                        int LA96_0 = input.LA(1);

                        if ( (LA96_0==93) ) {
                            int LA96_2 = input.LA(2);

                            if ( (synpred39_InternalBlangDsl()) ) {
                                alt96=1;
                            }


                        }


                        switch (alt96) {
                    	case 1 :
                    	    // InternalBlangDsl.g:6120:6: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // InternalBlangDsl.g:6121:6: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // InternalBlangDsl.g:6122:7: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_78);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"catchClauses",
                    	      								lv_catchClauses_3_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XCatchClause");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt96 >= 1 ) break loop96;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(96, input);
                                throw eee;
                        }
                        cnt96++;
                    } while (true);

                    // InternalBlangDsl.g:6139:5: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==91) ) {
                        int LA97_1 = input.LA(2);

                        if ( (synpred40_InternalBlangDsl()) ) {
                            alt97=1;
                        }
                    }
                    switch (alt97) {
                        case 1 :
                            // InternalBlangDsl.g:6140:6: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // InternalBlangDsl.g:6140:6: ( ( 'finally' )=>otherlv_4= 'finally' )
                            // InternalBlangDsl.g:6141:7: ( 'finally' )=>otherlv_4= 'finally'
                            {
                            otherlv_4=(Token)match(input,91,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                              						
                            }

                            }

                            // InternalBlangDsl.g:6147:6: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // InternalBlangDsl.g:6148:7: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // InternalBlangDsl.g:6148:7: (lv_finallyExpression_5_0= ruleXExpression )
                            // InternalBlangDsl.g:6149:8: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                              								}
                              								set(
                              									current,
                              									"finallyExpression",
                              									lv_finallyExpression_5_0,
                              									"org.eclipse.xtext.xbase.Xbase.XExpression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:6169:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // InternalBlangDsl.g:6169:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // InternalBlangDsl.g:6170:5: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,91,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                      				
                    }
                    // InternalBlangDsl.g:6174:5: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // InternalBlangDsl.g:6175:6: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // InternalBlangDsl.g:6175:6: (lv_finallyExpression_7_0= ruleXExpression )
                    // InternalBlangDsl.g:6176:7: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                      							}
                      							set(
                      								current,
                      								"finallyExpression",
                      								lv_finallyExpression_7_0,
                      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXSynchronizedExpression"
    // InternalBlangDsl.g:6199:1: entryRuleXSynchronizedExpression returns [EObject current=null] : iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
    public final EObject entryRuleXSynchronizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSynchronizedExpression = null;


        try {
            // InternalBlangDsl.g:6199:64: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
            // InternalBlangDsl.g:6200:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSynchronizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSynchronizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSynchronizedExpression"


    // $ANTLR start "ruleXSynchronizedExpression"
    // InternalBlangDsl.g:6206:1: ruleXSynchronizedExpression returns [EObject current=null] : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXSynchronizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_3_0 = null;

        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6212:2: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // InternalBlangDsl.g:6213:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // InternalBlangDsl.g:6213:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
            // InternalBlangDsl.g:6214:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) )
            {
            // InternalBlangDsl.g:6214:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
            // InternalBlangDsl.g:6215:4: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            {
            // InternalBlangDsl.g:6222:4: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
            // InternalBlangDsl.g:6223:5: () otherlv_1= 'synchronized' otherlv_2= '('
            {
            // InternalBlangDsl.g:6223:5: ()
            // InternalBlangDsl.g:6224:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,92,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
              				
            }
            otherlv_2=(Token)match(input,23,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
              				
            }

            }


            }

            // InternalBlangDsl.g:6240:3: ( (lv_param_3_0= ruleXExpression ) )
            // InternalBlangDsl.g:6241:4: (lv_param_3_0= ruleXExpression )
            {
            // InternalBlangDsl.g:6241:4: (lv_param_3_0= ruleXExpression )
            // InternalBlangDsl.g:6242:5: lv_param_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_param_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
              					}
              					set(
              						current,
              						"param",
              						lv_param_3_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }
            // InternalBlangDsl.g:6263:3: ( (lv_expression_5_0= ruleXExpression ) )
            // InternalBlangDsl.g:6264:4: (lv_expression_5_0= ruleXExpression )
            {
            // InternalBlangDsl.g:6264:4: (lv_expression_5_0= ruleXExpression )
            // InternalBlangDsl.g:6265:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSynchronizedExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // InternalBlangDsl.g:6286:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // InternalBlangDsl.g:6286:53: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // InternalBlangDsl.g:6287:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // InternalBlangDsl.g:6293:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6299:2: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // InternalBlangDsl.g:6300:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // InternalBlangDsl.g:6300:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
            // InternalBlangDsl.g:6301:3: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
            {
            // InternalBlangDsl.g:6301:3: ( ( 'catch' )=>otherlv_0= 'catch' )
            // InternalBlangDsl.g:6302:4: ( 'catch' )=>otherlv_0= 'catch'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
              			
            }

            }

            otherlv_1=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBlangDsl.g:6312:3: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // InternalBlangDsl.g:6313:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // InternalBlangDsl.g:6313:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // InternalBlangDsl.g:6314:5: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_43);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              					}
              					set(
              						current,
              						"declaredParam",
              						lv_declaredParam_2_0,
              						"org.eclipse.xtext.xbase.Xbase.FullJvmFormalParameter");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalBlangDsl.g:6335:3: ( (lv_expression_4_0= ruleXExpression ) )
            // InternalBlangDsl.g:6336:4: (lv_expression_4_0= ruleXExpression )
            {
            // InternalBlangDsl.g:6336:4: (lv_expression_4_0= ruleXExpression )
            // InternalBlangDsl.g:6337:5: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_4_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalBlangDsl.g:6358:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalBlangDsl.g:6358:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalBlangDsl.g:6359:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalBlangDsl.g:6365:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6371:2: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
            // InternalBlangDsl.g:6372:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            {
            // InternalBlangDsl.g:6372:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
            // InternalBlangDsl.g:6373:3: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_79);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ValidID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBlangDsl.g:6383:3: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==60) ) {
                    int LA99_2 = input.LA(2);

                    if ( (LA99_2==RULE_ID) ) {
                        int LA99_3 = input.LA(3);

                        if ( (synpred43_InternalBlangDsl()) ) {
                            alt99=1;
                        }


                    }


                }


                switch (alt99) {
            	case 1 :
            	    // InternalBlangDsl.g:6384:4: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
            	    {
            	    // InternalBlangDsl.g:6384:4: ( ( '.' )=>kw= '.' )
            	    // InternalBlangDsl.g:6385:5: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,60,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current.merge(kw);
            	      					newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_79);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ValidID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop99;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // InternalBlangDsl.g:6407:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalBlangDsl.g:6409:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalBlangDsl.g:6410:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalBlangDsl.g:6419:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalBlangDsl.g:6426:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // InternalBlangDsl.g:6427:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // InternalBlangDsl.g:6427:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_HEX) ) {
                alt103=1;
            }
            else if ( ((LA103_0>=RULE_INT && LA103_0<=RULE_DECIMAL)) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalBlangDsl.g:6428:3: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_HEX_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:6436:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // InternalBlangDsl.g:6436:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // InternalBlangDsl.g:6437:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // InternalBlangDsl.g:6437:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==RULE_INT) ) {
                        alt100=1;
                    }
                    else if ( (LA100_0==RULE_DECIMAL) ) {
                        alt100=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 100, 0, input);

                        throw nvae;
                    }
                    switch (alt100) {
                        case 1 :
                            // InternalBlangDsl.g:6438:5: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_79); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(this_INT_1);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalBlangDsl.g:6446:5: this_DECIMAL_2= RULE_DECIMAL
                            {
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_79); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(this_DECIMAL_2);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalBlangDsl.g:6454:4: (kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt102=2;
                    int LA102_0 = input.LA(1);

                    if ( (LA102_0==60) ) {
                        int LA102_1 = input.LA(2);

                        if ( ((LA102_1>=RULE_INT && LA102_1<=RULE_DECIMAL)) ) {
                            alt102=1;
                        }
                    }
                    switch (alt102) {
                        case 1 :
                            // InternalBlangDsl.g:6455:5: kw= '.' (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            kw=(Token)match(input,60,FOLLOW_80); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0());
                              				
                            }
                            // InternalBlangDsl.g:6460:5: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt101=2;
                            int LA101_0 = input.LA(1);

                            if ( (LA101_0==RULE_INT) ) {
                                alt101=1;
                            }
                            else if ( (LA101_0==RULE_DECIMAL) ) {
                                alt101=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 101, 0, input);

                                throw nvae;
                            }
                            switch (alt101) {
                                case 1 :
                                    // InternalBlangDsl.g:6461:6: this_INT_4= RULE_INT
                                    {
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						current.merge(this_INT_4);
                                      					
                                    }
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0());
                                      					
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalBlangDsl.g:6469:6: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						current.merge(this_DECIMAL_5);
                                      					
                                    }
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1());
                                      					
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJvmTypeReference"
    // InternalBlangDsl.g:6486:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // InternalBlangDsl.g:6486:57: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // InternalBlangDsl.g:6487:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // InternalBlangDsl.g:6493:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_3 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6499:2: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
            // InternalBlangDsl.g:6500:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            {
            // InternalBlangDsl.g:6500:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_ID) ) {
                alt105=1;
            }
            else if ( (LA105_0==23||LA105_0==47) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalBlangDsl.g:6501:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // InternalBlangDsl.g:6501:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // InternalBlangDsl.g:6502:4: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_73);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_JvmParameterizedTypeReference_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalBlangDsl.g:6510:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop104:
                    do {
                        int alt104=2;
                        int LA104_0 = input.LA(1);

                        if ( (LA104_0==64) ) {
                            int LA104_2 = input.LA(2);

                            if ( (LA104_2==65) ) {
                                int LA104_3 = input.LA(3);

                                if ( (synpred44_InternalBlangDsl()) ) {
                                    alt104=1;
                                }


                            }


                        }


                        switch (alt104) {
                    	case 1 :
                    	    // InternalBlangDsl.g:6511:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // InternalBlangDsl.g:6517:5: ( () ruleArrayBrackets )
                    	    // InternalBlangDsl.g:6518:6: () ruleArrayBrackets
                    	    {
                    	    // InternalBlangDsl.g:6518:6: ()
                    	    // InternalBlangDsl.g:6519:7: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							current = forceCreateModelElementAndSet(
                    	      								grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	      								current);
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_73);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop104;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:6536:3: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XFunctionTypeRef_3=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XFunctionTypeRef_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // InternalBlangDsl.g:6548:1: entryRuleArrayBrackets returns [String current=null] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final String entryRuleArrayBrackets() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrayBrackets = null;


        try {
            // InternalBlangDsl.g:6548:53: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // InternalBlangDsl.g:6549:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // InternalBlangDsl.g:6555:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:6561:2: ( (kw= '[' kw= ']' ) )
            // InternalBlangDsl.g:6562:2: (kw= '[' kw= ']' )
            {
            // InternalBlangDsl.g:6562:2: (kw= '[' kw= ']' )
            // InternalBlangDsl.g:6563:3: kw= '[' kw= ']'
            {
            kw=(Token)match(input,64,FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0());
              		
            }
            kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // InternalBlangDsl.g:6577:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // InternalBlangDsl.g:6577:57: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // InternalBlangDsl.g:6578:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // InternalBlangDsl.g:6584:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6590:2: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // InternalBlangDsl.g:6591:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // InternalBlangDsl.g:6591:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // InternalBlangDsl.g:6592:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // InternalBlangDsl.g:6592:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==23) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalBlangDsl.g:6593:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_81); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                      			
                    }
                    // InternalBlangDsl.g:6597:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==RULE_ID||LA107_0==23||LA107_0==47) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // InternalBlangDsl.g:6598:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // InternalBlangDsl.g:6598:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // InternalBlangDsl.g:6599:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // InternalBlangDsl.g:6599:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // InternalBlangDsl.g:6600:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_16);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                              							}
                              							add(
                              								current,
                              								"paramTypes",
                              								lv_paramTypes_1_0,
                              								"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalBlangDsl.g:6617:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop106:
                            do {
                                int alt106=2;
                                int LA106_0 = input.LA(1);

                                if ( (LA106_0==24) ) {
                                    alt106=1;
                                }


                                switch (alt106) {
                            	case 1 :
                            	    // InternalBlangDsl.g:6618:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,24,FOLLOW_11); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	      					
                            	    }
                            	    // InternalBlangDsl.g:6622:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // InternalBlangDsl.g:6623:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // InternalBlangDsl.g:6623:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // InternalBlangDsl.g:6624:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_16);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"paramTypes",
                            	      									lv_paramTypes_3_0,
                            	      									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop106;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_82); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,47,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
              		
            }
            // InternalBlangDsl.g:6652:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:6653:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:6653:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:6654:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              					}
              					set(
              						current,
              						"returnType",
              						lv_returnType_6_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // InternalBlangDsl.g:6675:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // InternalBlangDsl.g:6675:70: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // InternalBlangDsl.g:6676:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // InternalBlangDsl.g:6682:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6688:2: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
            // InternalBlangDsl.g:6689:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            {
            // InternalBlangDsl.g:6689:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
            // InternalBlangDsl.g:6690:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            {
            // InternalBlangDsl.g:6690:3: ( ( ruleQualifiedName ) )
            // InternalBlangDsl.g:6691:4: ( ruleQualifiedName )
            {
            // InternalBlangDsl.g:6691:4: ( ruleQualifiedName )
            // InternalBlangDsl.g:6692:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_83);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBlangDsl.g:6706:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
            int alt113=2;
            alt113 = dfa113.predict(input);
            switch (alt113) {
                case 1 :
                    // InternalBlangDsl.g:6707:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    {
                    // InternalBlangDsl.g:6707:4: ( ( '<' )=>otherlv_1= '<' )
                    // InternalBlangDsl.g:6708:5: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                      				
                    }

                    }

                    // InternalBlangDsl.g:6714:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // InternalBlangDsl.g:6715:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalBlangDsl.g:6715:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // InternalBlangDsl.g:6716:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      						}
                      						add(
                      							current,
                      							"arguments",
                      							lv_arguments_2_0,
                      							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBlangDsl.g:6733:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop109:
                    do {
                        int alt109=2;
                        int LA109_0 = input.LA(1);

                        if ( (LA109_0==24) ) {
                            alt109=1;
                        }


                        switch (alt109) {
                    	case 1 :
                    	    // InternalBlangDsl.g:6734:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,24,FOLLOW_39); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalBlangDsl.g:6738:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalBlangDsl.g:6739:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalBlangDsl.g:6739:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // InternalBlangDsl.g:6740:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_40);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"arguments",
                    	      								lv_arguments_4_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop109;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,35,FOLLOW_79); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                      			
                    }
                    // InternalBlangDsl.g:6762:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
                    loop112:
                    do {
                        int alt112=2;
                        int LA112_0 = input.LA(1);

                        if ( (LA112_0==60) ) {
                            int LA112_2 = input.LA(2);

                            if ( (LA112_2==RULE_ID) ) {
                                int LA112_3 = input.LA(3);

                                if ( (synpred46_InternalBlangDsl()) ) {
                                    alt112=1;
                                }


                            }


                        }


                        switch (alt112) {
                    	case 1 :
                    	    // InternalBlangDsl.g:6763:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    {
                    	    // InternalBlangDsl.g:6763:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
                    	    // InternalBlangDsl.g:6764:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
                    	    {
                    	    // InternalBlangDsl.g:6770:6: ( () otherlv_7= '.' )
                    	    // InternalBlangDsl.g:6771:7: () otherlv_7= '.'
                    	    {
                    	    // InternalBlangDsl.g:6771:7: ()
                    	    // InternalBlangDsl.g:6772:8: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								current = forceCreateModelElementAndSet(
                    	      									grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
                    	      									current);
                    	      							
                    	    }

                    	    }

                    	    otherlv_7=(Token)match(input,60,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_7, grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // InternalBlangDsl.g:6784:5: ( ( ruleValidID ) )
                    	    // InternalBlangDsl.g:6785:6: ( ruleValidID )
                    	    {
                    	    // InternalBlangDsl.g:6785:6: ( ruleValidID )
                    	    // InternalBlangDsl.g:6786:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_84);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // InternalBlangDsl.g:6800:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
                    	    int alt111=2;
                    	    alt111 = dfa111.predict(input);
                    	    switch (alt111) {
                    	        case 1 :
                    	            // InternalBlangDsl.g:6801:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
                    	            {
                    	            // InternalBlangDsl.g:6801:6: ( ( '<' )=>otherlv_9= '<' )
                    	            // InternalBlangDsl.g:6802:7: ( '<' )=>otherlv_9= '<'
                    	            {
                    	            otherlv_9=(Token)match(input,34,FOLLOW_39); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
                    	              						
                    	            }

                    	            }

                    	            // InternalBlangDsl.g:6808:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // InternalBlangDsl.g:6809:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // InternalBlangDsl.g:6809:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // InternalBlangDsl.g:6810:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_40);
                    	            lv_arguments_10_0=ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"arguments",
                    	              									lv_arguments_10_0,
                    	              									"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // InternalBlangDsl.g:6827:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop110:
                    	            do {
                    	                int alt110=2;
                    	                int LA110_0 = input.LA(1);

                    	                if ( (LA110_0==24) ) {
                    	                    alt110=1;
                    	                }


                    	                switch (alt110) {
                    	            	case 1 :
                    	            	    // InternalBlangDsl.g:6828:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    otherlv_11=(Token)match(input,24,FOLLOW_39); if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
                    	            	      						
                    	            	    }
                    	            	    // InternalBlangDsl.g:6832:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // InternalBlangDsl.g:6833:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // InternalBlangDsl.g:6833:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // InternalBlangDsl.g:6834:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_40);
                    	            	    lv_arguments_12_0=ruleJvmArgumentTypeReference();

                    	            	    state._fsp--;
                    	            	    if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									if (current==null) {
                    	            	      										current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	            	      									}
                    	            	      									add(
                    	            	      										current,
                    	            	      										"arguments",
                    	            	      										lv_arguments_12_0,
                    	            	      										"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	            	      									afterParserOrEnumRuleCall();
                    	            	      								
                    	            	    }

                    	            	    }


                    	            	    }


                    	            	    }
                    	            	    break;

                    	            	default :
                    	            	    break loop110;
                    	                }
                    	            } while (true);

                    	            otherlv_13=(Token)match(input,35,FOLLOW_79); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_13, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop112;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // InternalBlangDsl.g:6863:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // InternalBlangDsl.g:6863:65: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // InternalBlangDsl.g:6864:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // InternalBlangDsl.g:6870:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6876:2: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // InternalBlangDsl.g:6877:2: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // InternalBlangDsl.g:6877:2: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==RULE_ID||LA114_0==23||LA114_0==47) ) {
                alt114=1;
            }
            else if ( (LA114_0==94) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // InternalBlangDsl.g:6878:3: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JvmTypeReference_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:6887:3: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JvmWildcardTypeReference_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // InternalBlangDsl.g:6899:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // InternalBlangDsl.g:6899:65: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // InternalBlangDsl.g:6900:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // InternalBlangDsl.g:6906:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;

        EObject lv_constraints_4_0 = null;

        EObject lv_constraints_5_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:6912:2: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // InternalBlangDsl.g:6913:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // InternalBlangDsl.g:6913:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // InternalBlangDsl.g:6914:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // InternalBlangDsl.g:6914:3: ()
            // InternalBlangDsl.g:6915:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,94,FOLLOW_85); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
              		
            }
            // InternalBlangDsl.g:6925:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            int alt117=3;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==78) ) {
                alt117=1;
            }
            else if ( (LA117_0==82) ) {
                alt117=2;
            }
            switch (alt117) {
                case 1 :
                    // InternalBlangDsl.g:6926:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // InternalBlangDsl.g:6926:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // InternalBlangDsl.g:6927:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // InternalBlangDsl.g:6927:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // InternalBlangDsl.g:6928:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // InternalBlangDsl.g:6928:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // InternalBlangDsl.g:6929:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0());
                      						
                    }
                    pushFollow(FOLLOW_86);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      							}
                      							add(
                      								current,
                      								"constraints",
                      								lv_constraints_2_0,
                      								"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalBlangDsl.g:6946:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==95) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalBlangDsl.g:6947:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // InternalBlangDsl.g:6947:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // InternalBlangDsl.g:6948:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_86);
                    	    lv_constraints_3_0=ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"constraints",
                    	      								lv_constraints_3_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop115;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:6967:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // InternalBlangDsl.g:6967:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // InternalBlangDsl.g:6968:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // InternalBlangDsl.g:6968:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // InternalBlangDsl.g:6969:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // InternalBlangDsl.g:6969:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // InternalBlangDsl.g:6970:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_86);
                    lv_constraints_4_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      							}
                      							add(
                      								current,
                      								"constraints",
                      								lv_constraints_4_0,
                      								"org.eclipse.xtext.xbase.Xtype.JvmLowerBound");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalBlangDsl.g:6987:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==95) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // InternalBlangDsl.g:6988:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // InternalBlangDsl.g:6988:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // InternalBlangDsl.g:6989:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_86);
                    	    lv_constraints_5_0=ruleJvmLowerBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"constraints",
                    	      								lv_constraints_5_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmLowerBoundAnded");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop116;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // InternalBlangDsl.g:7012:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // InternalBlangDsl.g:7012:54: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // InternalBlangDsl.g:7013:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // InternalBlangDsl.g:7019:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:7025:2: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalBlangDsl.g:7026:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalBlangDsl.g:7026:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalBlangDsl.g:7027:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,78,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
              		
            }
            // InternalBlangDsl.g:7031:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:7032:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:7032:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:7033:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              					}
              					set(
              						current,
              						"typeReference",
              						lv_typeReference_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // InternalBlangDsl.g:7054:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // InternalBlangDsl.g:7054:59: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // InternalBlangDsl.g:7055:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // InternalBlangDsl.g:7061:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:7067:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalBlangDsl.g:7068:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalBlangDsl.g:7068:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalBlangDsl.g:7069:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,95,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
              		
            }
            // InternalBlangDsl.g:7073:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:7074:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:7074:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:7075:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              					}
              					set(
              						current,
              						"typeReference",
              						lv_typeReference_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // InternalBlangDsl.g:7096:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // InternalBlangDsl.g:7096:54: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // InternalBlangDsl.g:7097:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // InternalBlangDsl.g:7103:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:7109:2: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalBlangDsl.g:7110:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalBlangDsl.g:7110:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalBlangDsl.g:7111:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,82,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
              		
            }
            // InternalBlangDsl.g:7115:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:7116:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:7116:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:7117:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              					}
              					set(
              						current,
              						"typeReference",
              						lv_typeReference_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmLowerBoundAnded"
    // InternalBlangDsl.g:7138:1: entryRuleJvmLowerBoundAnded returns [EObject current=null] : iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
    public final EObject entryRuleJvmLowerBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBoundAnded = null;


        try {
            // InternalBlangDsl.g:7138:59: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
            // InternalBlangDsl.g:7139:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundAndedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmLowerBoundAnded"


    // $ANTLR start "ruleJvmLowerBoundAnded"
    // InternalBlangDsl.g:7145:1: ruleJvmLowerBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:7151:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalBlangDsl.g:7152:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalBlangDsl.g:7152:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalBlangDsl.g:7153:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,95,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
              		
            }
            // InternalBlangDsl.g:7157:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalBlangDsl.g:7158:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalBlangDsl.g:7158:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalBlangDsl.g:7159:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmLowerBoundAndedRule());
              					}
              					set(
              						current,
              						"typeReference",
              						lv_typeReference_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmLowerBoundAnded"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalBlangDsl.g:7180:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalBlangDsl.g:7180:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalBlangDsl.g:7181:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalBlangDsl.g:7187:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:7193:2: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) )
            // InternalBlangDsl.g:7194:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
            {
            // InternalBlangDsl.g:7194:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
            // InternalBlangDsl.g:7195:3: this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*'
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_87);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_QualifiedName_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,60,FOLLOW_88); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1());
              		
            }
            kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleValidID"
    // InternalBlangDsl.g:7219:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalBlangDsl.g:7219:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalBlangDsl.g:7220:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalBlangDsl.g:7226:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalBlangDsl.g:7232:2: (this_ID_0= RULE_ID )
            // InternalBlangDsl.g:7233:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportSection"
    // InternalBlangDsl.g:7243:1: entryRuleXImportSection returns [EObject current=null] : iv_ruleXImportSection= ruleXImportSection EOF ;
    public final EObject entryRuleXImportSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportSection = null;


        try {
            // InternalBlangDsl.g:7243:55: (iv_ruleXImportSection= ruleXImportSection EOF )
            // InternalBlangDsl.g:7244:2: iv_ruleXImportSection= ruleXImportSection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportSectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportSection=ruleXImportSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportSection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXImportSection"


    // $ANTLR start "ruleXImportSection"
    // InternalBlangDsl.g:7250:1: ruleXImportSection returns [EObject current=null] : ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ ;
    public final EObject ruleXImportSection() throws RecognitionException {
        EObject current = null;

        EObject lv_importDeclarations_0_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:7256:2: ( ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+ )
            // InternalBlangDsl.g:7257:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            {
            // InternalBlangDsl.g:7257:2: ( (lv_importDeclarations_0_0= ruleXImportDeclaration ) )+
            int cnt118=0;
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==80) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // InternalBlangDsl.g:7258:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    {
            	    // InternalBlangDsl.g:7258:3: (lv_importDeclarations_0_0= ruleXImportDeclaration )
            	    // InternalBlangDsl.g:7259:4: lv_importDeclarations_0_0= ruleXImportDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getXImportSectionAccess().getImportDeclarationsXImportDeclarationParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_89);
            	    lv_importDeclarations_0_0=ruleXImportDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getXImportSectionRule());
            	      				}
            	      				add(
            	      					current,
            	      					"importDeclarations",
            	      					lv_importDeclarations_0_0,
            	      					"org.eclipse.xtext.xbase.Xtype.XImportDeclaration");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt118 >= 1 ) break loop118;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(118, input);
                        throw eee;
                }
                cnt118++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXImportSection"


    // $ANTLR start "entryRuleXImportDeclaration"
    // InternalBlangDsl.g:7279:1: entryRuleXImportDeclaration returns [EObject current=null] : iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
    public final EObject entryRuleXImportDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportDeclaration = null;


        try {
            // InternalBlangDsl.g:7279:59: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
            // InternalBlangDsl.g:7280:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // InternalBlangDsl.g:7286:1: ruleXImportDeclaration returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
    public final EObject ruleXImportDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_memberName_5_0 = null;

        AntlrDatatypeRuleToken lv_importedNamespace_7_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:7292:2: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
            // InternalBlangDsl.g:7293:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            {
            // InternalBlangDsl.g:7293:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
            // InternalBlangDsl.g:7294:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
            {
            otherlv_0=(Token)match(input,80,FOLLOW_90); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
              		
            }
            // InternalBlangDsl.g:7298:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt121=3;
            alt121 = dfa121.predict(input);
            switch (alt121) {
                case 1 :
                    // InternalBlangDsl.g:7299:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // InternalBlangDsl.g:7299:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // InternalBlangDsl.g:7300:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // InternalBlangDsl.g:7300:5: ( (lv_static_1_0= 'static' ) )
                    // InternalBlangDsl.g:7301:6: (lv_static_1_0= 'static' )
                    {
                    // InternalBlangDsl.g:7301:6: (lv_static_1_0= 'static' )
                    // InternalBlangDsl.g:7302:7: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,79,FOLLOW_91); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      							}
                      							setWithLastConsumed(current, "static", true, "static");
                      						
                    }

                    }


                    }

                    // InternalBlangDsl.g:7314:5: ( (lv_extension_2_0= 'extension' ) )?
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==81) ) {
                        alt119=1;
                    }
                    switch (alt119) {
                        case 1 :
                            // InternalBlangDsl.g:7315:6: (lv_extension_2_0= 'extension' )
                            {
                            // InternalBlangDsl.g:7315:6: (lv_extension_2_0= 'extension' )
                            // InternalBlangDsl.g:7316:7: lv_extension_2_0= 'extension'
                            {
                            lv_extension_2_0=(Token)match(input,81,FOLLOW_91); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_extension_2_0, grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getXImportDeclarationRule());
                              							}
                              							setWithLastConsumed(current, "extension", true, "extension");
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalBlangDsl.g:7328:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // InternalBlangDsl.g:7329:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // InternalBlangDsl.g:7329:6: ( ruleQualifiedNameInStaticImport )
                    // InternalBlangDsl.g:7330:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0());
                      						
                    }
                    pushFollow(FOLLOW_92);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalBlangDsl.g:7344:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt120=2;
                    int LA120_0 = input.LA(1);

                    if ( (LA120_0==52) ) {
                        alt120=1;
                    }
                    else if ( (LA120_0==RULE_ID) ) {
                        alt120=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 120, 0, input);

                        throw nvae;
                    }
                    switch (alt120) {
                        case 1 :
                            // InternalBlangDsl.g:7345:6: ( (lv_wildcard_4_0= '*' ) )
                            {
                            // InternalBlangDsl.g:7345:6: ( (lv_wildcard_4_0= '*' ) )
                            // InternalBlangDsl.g:7346:7: (lv_wildcard_4_0= '*' )
                            {
                            // InternalBlangDsl.g:7346:7: (lv_wildcard_4_0= '*' )
                            // InternalBlangDsl.g:7347:8: lv_wildcard_4_0= '*'
                            {
                            lv_wildcard_4_0=(Token)match(input,52,FOLLOW_93); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_wildcard_4_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getXImportDeclarationRule());
                              								}
                              								setWithLastConsumed(current, "wildcard", true, "*");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBlangDsl.g:7360:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // InternalBlangDsl.g:7360:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // InternalBlangDsl.g:7361:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // InternalBlangDsl.g:7361:7: (lv_memberName_5_0= ruleValidID )
                            // InternalBlangDsl.g:7362:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0());
                              							
                            }
                            pushFollow(FOLLOW_93);
                            lv_memberName_5_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
                              								}
                              								set(
                              									current,
                              									"memberName",
                              									lv_memberName_5_0,
                              									"org.eclipse.xtext.xbase.Xtype.ValidID");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBlangDsl.g:7382:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalBlangDsl.g:7382:4: ( ( ruleQualifiedName ) )
                    // InternalBlangDsl.g:7383:5: ( ruleQualifiedName )
                    {
                    // InternalBlangDsl.g:7383:5: ( ruleQualifiedName )
                    // InternalBlangDsl.g:7384:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_93);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBlangDsl.g:7399:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // InternalBlangDsl.g:7399:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // InternalBlangDsl.g:7400:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // InternalBlangDsl.g:7400:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // InternalBlangDsl.g:7401:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_93);
                    lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"importedNamespace",
                      							lv_importedNamespace_7_0,
                      							"org.eclipse.xtext.xbase.Xtype.QualifiedNameWithWildcard");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBlangDsl.g:7419:3: (otherlv_8= ';' )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==66) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalBlangDsl.g:7420:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleQualifiedNameInStaticImport"
    // InternalBlangDsl.g:7429:1: entryRuleQualifiedNameInStaticImport returns [String current=null] : iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
    public final String entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameInStaticImport = null;


        try {
            // InternalBlangDsl.g:7429:67: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
            // InternalBlangDsl.g:7430:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameInStaticImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameInStaticImport.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameInStaticImport"


    // $ANTLR start "ruleQualifiedNameInStaticImport"
    // InternalBlangDsl.g:7436:1: ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '.' )+ ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameInStaticImport() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;



        	enterRule();

        try {
            // InternalBlangDsl.g:7442:2: ( (this_ValidID_0= ruleValidID kw= '.' )+ )
            // InternalBlangDsl.g:7443:2: (this_ValidID_0= ruleValidID kw= '.' )+
            {
            // InternalBlangDsl.g:7443:2: (this_ValidID_0= ruleValidID kw= '.' )+
            int cnt123=0;
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==RULE_ID) ) {
                    int LA123_2 = input.LA(2);

                    if ( (LA123_2==60) ) {
                        alt123=1;
                    }


                }


                switch (alt123) {
            	case 1 :
            	    // InternalBlangDsl.g:7444:3: this_ValidID_0= ruleValidID kw= '.'
            	    {
            	    if ( state.backtracking==0 ) {

            	      			newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0());
            	      		
            	    }
            	    pushFollow(FOLLOW_87);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			current.merge(this_ValidID_0);
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			afterParserOrEnumRuleCall();
            	      		
            	    }
            	    kw=(Token)match(input,60,FOLLOW_94); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			current.merge(kw);
            	      			newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1());
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt123 >= 1 ) break loop123;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(123, input);
                        throw eee;
                }
                cnt123++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameInStaticImport"

    // $ANTLR start synpred2_InternalBlangDsl
    public final void synpred2_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:1248:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // InternalBlangDsl.g:1248:7: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // InternalBlangDsl.g:1248:7: ( () ( ( ruleOpMultiAssign ) ) )
        // InternalBlangDsl.g:1249:7: () ( ( ruleOpMultiAssign ) )
        {
        // InternalBlangDsl.g:1249:7: ()
        // InternalBlangDsl.g:1250:7: 
        {
        }

        // InternalBlangDsl.g:1251:7: ( ( ruleOpMultiAssign ) )
        // InternalBlangDsl.g:1252:8: ( ruleOpMultiAssign )
        {
        // InternalBlangDsl.g:1252:8: ( ruleOpMultiAssign )
        // InternalBlangDsl.g:1253:9: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_2);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalBlangDsl

    // $ANTLR start synpred3_InternalBlangDsl
    public final void synpred3_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:1442:5: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalBlangDsl.g:1442:6: ( () ( ( ruleOpOr ) ) )
        {
        // InternalBlangDsl.g:1442:6: ( () ( ( ruleOpOr ) ) )
        // InternalBlangDsl.g:1443:6: () ( ( ruleOpOr ) )
        {
        // InternalBlangDsl.g:1443:6: ()
        // InternalBlangDsl.g:1444:6: 
        {
        }

        // InternalBlangDsl.g:1445:6: ( ( ruleOpOr ) )
        // InternalBlangDsl.g:1446:7: ( ruleOpOr )
        {
        // InternalBlangDsl.g:1446:7: ( ruleOpOr )
        // InternalBlangDsl.g:1447:8: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalBlangDsl

    // $ANTLR start synpred4_InternalBlangDsl
    public final void synpred4_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:1549:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalBlangDsl.g:1549:6: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalBlangDsl.g:1549:6: ( () ( ( ruleOpAnd ) ) )
        // InternalBlangDsl.g:1550:6: () ( ( ruleOpAnd ) )
        {
        // InternalBlangDsl.g:1550:6: ()
        // InternalBlangDsl.g:1551:6: 
        {
        }

        // InternalBlangDsl.g:1552:6: ( ( ruleOpAnd ) )
        // InternalBlangDsl.g:1553:7: ( ruleOpAnd )
        {
        // InternalBlangDsl.g:1553:7: ( ruleOpAnd )
        // InternalBlangDsl.g:1554:8: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalBlangDsl

    // $ANTLR start synpred5_InternalBlangDsl
    public final void synpred5_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:1656:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalBlangDsl.g:1656:6: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalBlangDsl.g:1656:6: ( () ( ( ruleOpEquality ) ) )
        // InternalBlangDsl.g:1657:6: () ( ( ruleOpEquality ) )
        {
        // InternalBlangDsl.g:1657:6: ()
        // InternalBlangDsl.g:1658:6: 
        {
        }

        // InternalBlangDsl.g:1659:6: ( ( ruleOpEquality ) )
        // InternalBlangDsl.g:1660:7: ( ruleOpEquality )
        {
        // InternalBlangDsl.g:1660:7: ( ruleOpEquality )
        // InternalBlangDsl.g:1661:8: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalBlangDsl

    // $ANTLR start synpred6_InternalBlangDsl
    public final void synpred6_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:1784:6: ( ( () 'instanceof' ) )
        // InternalBlangDsl.g:1784:7: ( () 'instanceof' )
        {
        // InternalBlangDsl.g:1784:7: ( () 'instanceof' )
        // InternalBlangDsl.g:1785:7: () 'instanceof'
        {
        // InternalBlangDsl.g:1785:7: ()
        // InternalBlangDsl.g:1786:7: 
        {
        }

        match(input,43,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalBlangDsl

    // $ANTLR start synpred7_InternalBlangDsl
    public final void synpred7_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:1827:6: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalBlangDsl.g:1827:7: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalBlangDsl.g:1827:7: ( () ( ( ruleOpCompare ) ) )
        // InternalBlangDsl.g:1828:7: () ( ( ruleOpCompare ) )
        {
        // InternalBlangDsl.g:1828:7: ()
        // InternalBlangDsl.g:1829:7: 
        {
        }

        // InternalBlangDsl.g:1830:7: ( ( ruleOpCompare ) )
        // InternalBlangDsl.g:1831:8: ( ruleOpCompare )
        {
        // InternalBlangDsl.g:1831:8: ( ruleOpCompare )
        // InternalBlangDsl.g:1832:9: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalBlangDsl

    // $ANTLR start synpred8_InternalBlangDsl
    public final void synpred8_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:1962:5: ( ( () ( ( ruleOpOther ) ) ) )
        // InternalBlangDsl.g:1962:6: ( () ( ( ruleOpOther ) ) )
        {
        // InternalBlangDsl.g:1962:6: ( () ( ( ruleOpOther ) ) )
        // InternalBlangDsl.g:1963:6: () ( ( ruleOpOther ) )
        {
        // InternalBlangDsl.g:1963:6: ()
        // InternalBlangDsl.g:1964:6: 
        {
        }

        // InternalBlangDsl.g:1965:6: ( ( ruleOpOther ) )
        // InternalBlangDsl.g:1966:7: ( ruleOpOther )
        {
        // InternalBlangDsl.g:1966:7: ( ruleOpOther )
        // InternalBlangDsl.g:1967:8: ruleOpOther
        {
        pushFollow(FOLLOW_2);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalBlangDsl

    // $ANTLR start synpred9_InternalBlangDsl
    public final void synpred9_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2082:6: ( ( '>' '>' ) )
        // InternalBlangDsl.g:2082:7: ( '>' '>' )
        {
        // InternalBlangDsl.g:2082:7: ( '>' '>' )
        // InternalBlangDsl.g:2083:7: '>' '>'
        {
        match(input,35,FOLLOW_30); if (state.failed) return ;
        match(input,35,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_InternalBlangDsl

    // $ANTLR start synpred10_InternalBlangDsl
    public final void synpred10_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2117:6: ( ( '<' '<' ) )
        // InternalBlangDsl.g:2117:7: ( '<' '<' )
        {
        // InternalBlangDsl.g:2117:7: ( '<' '<' )
        // InternalBlangDsl.g:2118:7: '<' '<'
        {
        match(input,34,FOLLOW_21); if (state.failed) return ;
        match(input,34,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalBlangDsl

    // $ANTLR start synpred11_InternalBlangDsl
    public final void synpred11_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2190:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalBlangDsl.g:2190:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalBlangDsl.g:2190:6: ( () ( ( ruleOpAdd ) ) )
        // InternalBlangDsl.g:2191:6: () ( ( ruleOpAdd ) )
        {
        // InternalBlangDsl.g:2191:6: ()
        // InternalBlangDsl.g:2192:6: 
        {
        }

        // InternalBlangDsl.g:2193:6: ( ( ruleOpAdd ) )
        // InternalBlangDsl.g:2194:7: ( ruleOpAdd )
        {
        // InternalBlangDsl.g:2194:7: ( ruleOpAdd )
        // InternalBlangDsl.g:2195:8: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalBlangDsl

    // $ANTLR start synpred12_InternalBlangDsl
    public final void synpred12_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2305:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalBlangDsl.g:2305:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalBlangDsl.g:2305:6: ( () ( ( ruleOpMulti ) ) )
        // InternalBlangDsl.g:2306:6: () ( ( ruleOpMulti ) )
        {
        // InternalBlangDsl.g:2306:6: ()
        // InternalBlangDsl.g:2307:6: 
        {
        }

        // InternalBlangDsl.g:2308:6: ( ( ruleOpMulti ) )
        // InternalBlangDsl.g:2309:7: ( ruleOpMulti )
        {
        // InternalBlangDsl.g:2309:7: ( ruleOpMulti )
        // InternalBlangDsl.g:2310:8: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred12_InternalBlangDsl

    // $ANTLR start synpred13_InternalBlangDsl
    public final void synpred13_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2540:5: ( ( () 'as' ) )
        // InternalBlangDsl.g:2540:6: ( () 'as' )
        {
        // InternalBlangDsl.g:2540:6: ( () 'as' )
        // InternalBlangDsl.g:2541:6: () 'as'
        {
        // InternalBlangDsl.g:2541:6: ()
        // InternalBlangDsl.g:2542:6: 
        {
        }

        match(input,57,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalBlangDsl

    // $ANTLR start synpred14_InternalBlangDsl
    public final void synpred14_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2608:4: ( ( () ( ( ruleOpPostfix ) ) ) )
        // InternalBlangDsl.g:2608:5: ( () ( ( ruleOpPostfix ) ) )
        {
        // InternalBlangDsl.g:2608:5: ( () ( ( ruleOpPostfix ) ) )
        // InternalBlangDsl.g:2609:5: () ( ( ruleOpPostfix ) )
        {
        // InternalBlangDsl.g:2609:5: ()
        // InternalBlangDsl.g:2610:5: 
        {
        }

        // InternalBlangDsl.g:2611:5: ( ( ruleOpPostfix ) )
        // InternalBlangDsl.g:2612:6: ( ruleOpPostfix )
        {
        // InternalBlangDsl.g:2612:6: ( ruleOpPostfix )
        // InternalBlangDsl.g:2613:7: ruleOpPostfix
        {
        pushFollow(FOLLOW_2);
        ruleOpPostfix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred14_InternalBlangDsl

    // $ANTLR start synpred15_InternalBlangDsl
    public final void synpred15_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2704:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
        // InternalBlangDsl.g:2704:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        {
        // InternalBlangDsl.g:2704:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        // InternalBlangDsl.g:2705:7: () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
        {
        // InternalBlangDsl.g:2705:7: ()
        // InternalBlangDsl.g:2706:7: 
        {
        }

        // InternalBlangDsl.g:2707:7: ( '.' | ( ( '::' ) ) )
        int alt124=2;
        int LA124_0 = input.LA(1);

        if ( (LA124_0==60) ) {
            alt124=1;
        }
        else if ( (LA124_0==61) ) {
            alt124=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 124, 0, input);

            throw nvae;
        }
        switch (alt124) {
            case 1 :
                // InternalBlangDsl.g:2708:8: '.'
                {
                match(input,60,FOLLOW_37); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBlangDsl.g:2710:8: ( ( '::' ) )
                {
                // InternalBlangDsl.g:2710:8: ( ( '::' ) )
                // InternalBlangDsl.g:2711:9: ( '::' )
                {
                // InternalBlangDsl.g:2711:9: ( '::' )
                // InternalBlangDsl.g:2712:10: '::'
                {
                match(input,61,FOLLOW_37); if (state.failed) return ;

                }


                }


                }
                break;

        }

        // InternalBlangDsl.g:2716:7: ( ( ruleFeatureCallID ) )
        // InternalBlangDsl.g:2717:8: ( ruleFeatureCallID )
        {
        // InternalBlangDsl.g:2717:8: ( ruleFeatureCallID )
        // InternalBlangDsl.g:2718:9: ruleFeatureCallID
        {
        pushFollow(FOLLOW_12);
        ruleFeatureCallID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_2);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalBlangDsl

    // $ANTLR start synpred16_InternalBlangDsl
    public final void synpred16_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2801:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )
        // InternalBlangDsl.g:2801:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        {
        // InternalBlangDsl.g:2801:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
        // InternalBlangDsl.g:2802:7: () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        {
        // InternalBlangDsl.g:2802:7: ()
        // InternalBlangDsl.g:2803:7: 
        {
        }

        // InternalBlangDsl.g:2804:7: ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
        int alt125=3;
        switch ( input.LA(1) ) {
        case 60:
            {
            alt125=1;
            }
            break;
        case 62:
            {
            alt125=2;
            }
            break;
        case 61:
            {
            alt125=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 125, 0, input);

            throw nvae;
        }

        switch (alt125) {
            case 1 :
                // InternalBlangDsl.g:2805:8: '.'
                {
                match(input,60,FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalBlangDsl.g:2807:8: ( ( '?.' ) )
                {
                // InternalBlangDsl.g:2807:8: ( ( '?.' ) )
                // InternalBlangDsl.g:2808:9: ( '?.' )
                {
                // InternalBlangDsl.g:2808:9: ( '?.' )
                // InternalBlangDsl.g:2809:10: '?.'
                {
                match(input,62,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // InternalBlangDsl.g:2813:8: ( ( '::' ) )
                {
                // InternalBlangDsl.g:2813:8: ( ( '::' ) )
                // InternalBlangDsl.g:2814:9: ( '::' )
                {
                // InternalBlangDsl.g:2814:9: ( '::' )
                // InternalBlangDsl.g:2815:10: '::'
                {
                match(input,61,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred16_InternalBlangDsl

    // $ANTLR start synpred17_InternalBlangDsl
    public final void synpred17_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2939:7: ( ( '(' ) )
        // InternalBlangDsl.g:2939:8: ( '(' )
        {
        // InternalBlangDsl.g:2939:8: ( '(' )
        // InternalBlangDsl.g:2940:8: '('
        {
        match(input,23,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred17_InternalBlangDsl

    // $ANTLR start synpred18_InternalBlangDsl
    public final void synpred18_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:2958:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // InternalBlangDsl.g:2958:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // InternalBlangDsl.g:2958:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // InternalBlangDsl.g:2959:9: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // InternalBlangDsl.g:2959:9: ()
        // InternalBlangDsl.g:2960:9: 
        {
        }

        // InternalBlangDsl.g:2961:9: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt127=2;
        int LA127_0 = input.LA(1);

        if ( (LA127_0==RULE_ID||LA127_0==23||LA127_0==47) ) {
            alt127=1;
        }
        switch (alt127) {
            case 1 :
                // InternalBlangDsl.g:2962:10: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalBlangDsl.g:2962:10: ( ( ruleJvmFormalParameter ) )
                // InternalBlangDsl.g:2963:11: ( ruleJvmFormalParameter )
                {
                // InternalBlangDsl.g:2963:11: ( ruleJvmFormalParameter )
                // InternalBlangDsl.g:2964:12: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_51);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalBlangDsl.g:2967:10: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop126:
                do {
                    int alt126=2;
                    int LA126_0 = input.LA(1);

                    if ( (LA126_0==24) ) {
                        alt126=1;
                    }


                    switch (alt126) {
                	case 1 :
                	    // InternalBlangDsl.g:2968:11: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,24,FOLLOW_11); if (state.failed) return ;
                	    // InternalBlangDsl.g:2969:11: ( ( ruleJvmFormalParameter ) )
                	    // InternalBlangDsl.g:2970:12: ( ruleJvmFormalParameter )
                	    {
                	    // InternalBlangDsl.g:2970:12: ( ruleJvmFormalParameter )
                	    // InternalBlangDsl.g:2971:13: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_51);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop126;
                    }
                } while (true);


                }
                break;

        }

        // InternalBlangDsl.g:2976:9: ( ( '|' ) )
        // InternalBlangDsl.g:2977:10: ( '|' )
        {
        // InternalBlangDsl.g:2977:10: ( '|' )
        // InternalBlangDsl.g:2978:11: '|'
        {
        match(input,27,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred18_InternalBlangDsl

    // $ANTLR start synpred19_InternalBlangDsl
    public final void synpred19_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:3055:6: ( ( () '[' ) )
        // InternalBlangDsl.g:3055:7: ( () '[' )
        {
        // InternalBlangDsl.g:3055:7: ( () '[' )
        // InternalBlangDsl.g:3056:7: () '['
        {
        // InternalBlangDsl.g:3056:7: ()
        // InternalBlangDsl.g:3057:7: 
        {
        }

        match(input,64,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalBlangDsl

    // $ANTLR start synpred20_InternalBlangDsl
    public final void synpred20_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:3128:4: ( ( () 'synchronized' '(' ) )
        // InternalBlangDsl.g:3128:5: ( () 'synchronized' '(' )
        {
        // InternalBlangDsl.g:3128:5: ( () 'synchronized' '(' )
        // InternalBlangDsl.g:3129:5: () 'synchronized' '('
        {
        // InternalBlangDsl.g:3129:5: ()
        // InternalBlangDsl.g:3130:5: 
        {
        }

        match(input,92,FOLLOW_15); if (state.failed) return ;
        match(input,23,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalBlangDsl

    // $ANTLR start synpred21_InternalBlangDsl
    public final void synpred21_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:3173:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // InternalBlangDsl.g:3173:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // InternalBlangDsl.g:3173:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // InternalBlangDsl.g:3174:5: () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        // InternalBlangDsl.g:3174:5: ()
        // InternalBlangDsl.g:3175:5: 
        {
        }

        match(input,73,FOLLOW_15); if (state.failed) return ;
        match(input,23,FOLLOW_11); if (state.failed) return ;
        // InternalBlangDsl.g:3178:5: ( ( ruleJvmFormalParameter ) )
        // InternalBlangDsl.g:3179:6: ( ruleJvmFormalParameter )
        {
        // InternalBlangDsl.g:3179:6: ( ruleJvmFormalParameter )
        // InternalBlangDsl.g:3180:7: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_58);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,70,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalBlangDsl

    // $ANTLR start synpred22_InternalBlangDsl
    public final void synpred22_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:3287:4: ( ( () '[' ) )
        // InternalBlangDsl.g:3287:5: ( () '[' )
        {
        // InternalBlangDsl.g:3287:5: ( () '[' )
        // InternalBlangDsl.g:3288:5: () '['
        {
        // InternalBlangDsl.g:3288:5: ()
        // InternalBlangDsl.g:3289:5: 
        {
        }

        match(input,64,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalBlangDsl

    // $ANTLR start synpred24_InternalBlangDsl
    public final void synpred24_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:3592:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // InternalBlangDsl.g:3592:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // InternalBlangDsl.g:3592:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // InternalBlangDsl.g:3593:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // InternalBlangDsl.g:3593:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt129=2;
        int LA129_0 = input.LA(1);

        if ( (LA129_0==RULE_ID||LA129_0==23||LA129_0==47) ) {
            alt129=1;
        }
        switch (alt129) {
            case 1 :
                // InternalBlangDsl.g:3594:6: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalBlangDsl.g:3594:6: ( ( ruleJvmFormalParameter ) )
                // InternalBlangDsl.g:3595:7: ( ruleJvmFormalParameter )
                {
                // InternalBlangDsl.g:3595:7: ( ruleJvmFormalParameter )
                // InternalBlangDsl.g:3596:8: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_51);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalBlangDsl.g:3599:6: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop128:
                do {
                    int alt128=2;
                    int LA128_0 = input.LA(1);

                    if ( (LA128_0==24) ) {
                        alt128=1;
                    }


                    switch (alt128) {
                	case 1 :
                	    // InternalBlangDsl.g:3600:7: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,24,FOLLOW_11); if (state.failed) return ;
                	    // InternalBlangDsl.g:3601:7: ( ( ruleJvmFormalParameter ) )
                	    // InternalBlangDsl.g:3602:8: ( ruleJvmFormalParameter )
                	    {
                	    // InternalBlangDsl.g:3602:8: ( ruleJvmFormalParameter )
                	    // InternalBlangDsl.g:3603:9: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_51);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop128;
                    }
                } while (true);


                }
                break;

        }

        // InternalBlangDsl.g:3608:5: ( ( '|' ) )
        // InternalBlangDsl.g:3609:6: ( '|' )
        {
        // InternalBlangDsl.g:3609:6: ( '|' )
        // InternalBlangDsl.g:3610:7: '|'
        {
        match(input,27,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalBlangDsl

    // $ANTLR start synpred26_InternalBlangDsl
    public final void synpred26_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:4001:5: ( 'else' )
        // InternalBlangDsl.g:4001:6: 'else'
        {
        match(input,68,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalBlangDsl

    // $ANTLR start synpred27_InternalBlangDsl
    public final void synpred27_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:4060:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
        // InternalBlangDsl.g:4060:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // InternalBlangDsl.g:4060:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
        // InternalBlangDsl.g:4061:7: '(' ( ( ruleJvmFormalParameter ) ) ':'
        {
        match(input,23,FOLLOW_11); if (state.failed) return ;
        // InternalBlangDsl.g:4062:7: ( ( ruleJvmFormalParameter ) )
        // InternalBlangDsl.g:4063:8: ( ruleJvmFormalParameter )
        {
        // InternalBlangDsl.g:4063:8: ( ruleJvmFormalParameter )
        // InternalBlangDsl.g:4064:9: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_58);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,70,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred27_InternalBlangDsl

    // $ANTLR start synpred28_InternalBlangDsl
    public final void synpred28_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:4127:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )
        // InternalBlangDsl.g:4127:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
        {
        // InternalBlangDsl.g:4127:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
        // InternalBlangDsl.g:4128:7: ( ( ruleJvmFormalParameter ) ) ':'
        {
        // InternalBlangDsl.g:4128:7: ( ( ruleJvmFormalParameter ) )
        // InternalBlangDsl.g:4129:8: ( ruleJvmFormalParameter )
        {
        // InternalBlangDsl.g:4129:8: ( ruleJvmFormalParameter )
        // InternalBlangDsl.g:4130:9: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_58);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,70,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred28_InternalBlangDsl

    // $ANTLR start synpred30_InternalBlangDsl
    public final void synpred30_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:4945:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // InternalBlangDsl.g:4945:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // InternalBlangDsl.g:4945:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // InternalBlangDsl.g:4946:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // InternalBlangDsl.g:4946:6: ( ( ruleJvmTypeReference ) )
        // InternalBlangDsl.g:4947:7: ( ruleJvmTypeReference )
        {
        // InternalBlangDsl.g:4947:7: ( ruleJvmTypeReference )
        // InternalBlangDsl.g:4948:8: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_3);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalBlangDsl.g:4951:6: ( ( ruleValidID ) )
        // InternalBlangDsl.g:4952:7: ( ruleValidID )
        {
        // InternalBlangDsl.g:4952:7: ( ruleValidID )
        // InternalBlangDsl.g:4953:8: ruleValidID
        {
        pushFollow(FOLLOW_2);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred30_InternalBlangDsl

    // $ANTLR start synpred31_InternalBlangDsl
    public final void synpred31_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:5257:5: ( ( '(' ) )
        // InternalBlangDsl.g:5257:6: ( '(' )
        {
        // InternalBlangDsl.g:5257:6: ( '(' )
        // InternalBlangDsl.g:5258:6: '('
        {
        match(input,23,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalBlangDsl

    // $ANTLR start synpred32_InternalBlangDsl
    public final void synpred32_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:5276:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // InternalBlangDsl.g:5276:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // InternalBlangDsl.g:5276:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // InternalBlangDsl.g:5277:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // InternalBlangDsl.g:5277:7: ()
        // InternalBlangDsl.g:5278:7: 
        {
        }

        // InternalBlangDsl.g:5279:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( (LA133_0==RULE_ID||LA133_0==23||LA133_0==47) ) {
            alt133=1;
        }
        switch (alt133) {
            case 1 :
                // InternalBlangDsl.g:5280:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalBlangDsl.g:5280:8: ( ( ruleJvmFormalParameter ) )
                // InternalBlangDsl.g:5281:9: ( ruleJvmFormalParameter )
                {
                // InternalBlangDsl.g:5281:9: ( ruleJvmFormalParameter )
                // InternalBlangDsl.g:5282:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_51);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalBlangDsl.g:5285:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop132:
                do {
                    int alt132=2;
                    int LA132_0 = input.LA(1);

                    if ( (LA132_0==24) ) {
                        alt132=1;
                    }


                    switch (alt132) {
                	case 1 :
                	    // InternalBlangDsl.g:5286:9: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,24,FOLLOW_11); if (state.failed) return ;
                	    // InternalBlangDsl.g:5287:9: ( ( ruleJvmFormalParameter ) )
                	    // InternalBlangDsl.g:5288:10: ( ruleJvmFormalParameter )
                	    {
                	    // InternalBlangDsl.g:5288:10: ( ruleJvmFormalParameter )
                	    // InternalBlangDsl.g:5289:11: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_51);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop132;
                    }
                } while (true);


                }
                break;

        }

        // InternalBlangDsl.g:5294:7: ( ( '|' ) )
        // InternalBlangDsl.g:5295:8: ( '|' )
        {
        // InternalBlangDsl.g:5295:8: ( '|' )
        // InternalBlangDsl.g:5296:9: '|'
        {
        match(input,27,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred32_InternalBlangDsl

    // $ANTLR start synpred33_InternalBlangDsl
    public final void synpred33_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:5373:4: ( ( () '[' ) )
        // InternalBlangDsl.g:5373:5: ( () '[' )
        {
        // InternalBlangDsl.g:5373:5: ( () '[' )
        // InternalBlangDsl.g:5374:5: () '['
        {
        // InternalBlangDsl.g:5374:5: ()
        // InternalBlangDsl.g:5375:5: 
        {
        }

        match(input,64,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred33_InternalBlangDsl

    // $ANTLR start synpred34_InternalBlangDsl
    public final void synpred34_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:5533:5: ( '<' )
        // InternalBlangDsl.g:5533:6: '<'
        {
        match(input,34,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalBlangDsl

    // $ANTLR start synpred35_InternalBlangDsl
    public final void synpred35_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:5590:5: ( ( '(' ) )
        // InternalBlangDsl.g:5590:6: ( '(' )
        {
        // InternalBlangDsl.g:5590:6: ( '(' )
        // InternalBlangDsl.g:5591:6: '('
        {
        match(input,23,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred35_InternalBlangDsl

    // $ANTLR start synpred36_InternalBlangDsl
    public final void synpred36_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:5609:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
        // InternalBlangDsl.g:5609:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        {
        // InternalBlangDsl.g:5609:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
        // InternalBlangDsl.g:5610:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
        {
        // InternalBlangDsl.g:5610:7: ()
        // InternalBlangDsl.g:5611:7: 
        {
        }

        // InternalBlangDsl.g:5612:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
        int alt135=2;
        int LA135_0 = input.LA(1);

        if ( (LA135_0==RULE_ID||LA135_0==23||LA135_0==47) ) {
            alt135=1;
        }
        switch (alt135) {
            case 1 :
                // InternalBlangDsl.g:5613:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalBlangDsl.g:5613:8: ( ( ruleJvmFormalParameter ) )
                // InternalBlangDsl.g:5614:9: ( ruleJvmFormalParameter )
                {
                // InternalBlangDsl.g:5614:9: ( ruleJvmFormalParameter )
                // InternalBlangDsl.g:5615:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_51);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalBlangDsl.g:5618:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
                loop134:
                do {
                    int alt134=2;
                    int LA134_0 = input.LA(1);

                    if ( (LA134_0==24) ) {
                        alt134=1;
                    }


                    switch (alt134) {
                	case 1 :
                	    // InternalBlangDsl.g:5619:9: ',' ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,24,FOLLOW_11); if (state.failed) return ;
                	    // InternalBlangDsl.g:5620:9: ( ( ruleJvmFormalParameter ) )
                	    // InternalBlangDsl.g:5621:10: ( ruleJvmFormalParameter )
                	    {
                	    // InternalBlangDsl.g:5621:10: ( ruleJvmFormalParameter )
                	    // InternalBlangDsl.g:5622:11: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_51);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop134;
                    }
                } while (true);


                }
                break;

        }

        // InternalBlangDsl.g:5627:7: ( ( '|' ) )
        // InternalBlangDsl.g:5628:8: ( '|' )
        {
        // InternalBlangDsl.g:5628:8: ( '|' )
        // InternalBlangDsl.g:5629:9: '|'
        {
        match(input,27,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred36_InternalBlangDsl

    // $ANTLR start synpred37_InternalBlangDsl
    public final void synpred37_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:5706:4: ( ( () '[' ) )
        // InternalBlangDsl.g:5706:5: ( () '[' )
        {
        // InternalBlangDsl.g:5706:5: ( () '[' )
        // InternalBlangDsl.g:5707:5: () '['
        {
        // InternalBlangDsl.g:5707:5: ()
        // InternalBlangDsl.g:5708:5: 
        {
        }

        match(input,64,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred37_InternalBlangDsl

    // $ANTLR start synpred38_InternalBlangDsl
    public final void synpred38_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:6049:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )
        // InternalBlangDsl.g:
        {
        if ( (input.LA(1)>=RULE_STRING && input.LA(1)<=RULE_ID)||input.LA(1)==15||input.LA(1)==23||input.LA(1)==34||(input.LA(1)>=50 && input.LA(1)<=51)||input.LA(1)==56||(input.LA(1)>=63 && input.LA(1)<=64)||input.LA(1)==67||input.LA(1)==69||(input.LA(1)>=73 && input.LA(1)<=75)||(input.LA(1)>=78 && input.LA(1)<=90)||input.LA(1)==92 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred38_InternalBlangDsl

    // $ANTLR start synpred39_InternalBlangDsl
    public final void synpred39_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:6120:6: ( 'catch' )
        // InternalBlangDsl.g:6120:7: 'catch'
        {
        match(input,93,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalBlangDsl

    // $ANTLR start synpred40_InternalBlangDsl
    public final void synpred40_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:6141:7: ( 'finally' )
        // InternalBlangDsl.g:6141:8: 'finally'
        {
        match(input,91,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalBlangDsl

    // $ANTLR start synpred43_InternalBlangDsl
    public final void synpred43_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:6385:5: ( '.' )
        // InternalBlangDsl.g:6385:6: '.'
        {
        match(input,60,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalBlangDsl

    // $ANTLR start synpred44_InternalBlangDsl
    public final void synpred44_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:6511:5: ( ( () ruleArrayBrackets ) )
        // InternalBlangDsl.g:6511:6: ( () ruleArrayBrackets )
        {
        // InternalBlangDsl.g:6511:6: ( () ruleArrayBrackets )
        // InternalBlangDsl.g:6512:6: () ruleArrayBrackets
        {
        // InternalBlangDsl.g:6512:6: ()
        // InternalBlangDsl.g:6513:6: 
        {
        }

        pushFollow(FOLLOW_2);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred44_InternalBlangDsl

    // $ANTLR start synpred45_InternalBlangDsl
    public final void synpred45_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:6708:5: ( '<' )
        // InternalBlangDsl.g:6708:6: '<'
        {
        match(input,34,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalBlangDsl

    // $ANTLR start synpred46_InternalBlangDsl
    public final void synpred46_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:6764:6: ( ( () '.' ) )
        // InternalBlangDsl.g:6764:7: ( () '.' )
        {
        // InternalBlangDsl.g:6764:7: ( () '.' )
        // InternalBlangDsl.g:6765:7: () '.'
        {
        // InternalBlangDsl.g:6765:7: ()
        // InternalBlangDsl.g:6766:7: 
        {
        }

        match(input,60,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred46_InternalBlangDsl

    // $ANTLR start synpred47_InternalBlangDsl
    public final void synpred47_InternalBlangDsl_fragment() throws RecognitionException {   
        // InternalBlangDsl.g:6802:7: ( '<' )
        // InternalBlangDsl.g:6802:8: '<'
        {
        match(input,34,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_InternalBlangDsl

    // Delegated rules

    public final boolean synpred26_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalBlangDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalBlangDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA88 dfa88 = new DFA88(this);
    protected DFA91 dfa91 = new DFA91(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA95 dfa95 = new DFA95(this);
    protected DFA113 dfa113 = new DFA113(this);
    protected DFA111 dfa111 = new DFA111(this);
    protected DFA121 dfa121 = new DFA121(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\10\11\uffff";
    static final String dfa_3s = "\1\4\7\0\2\uffff";
    static final String dfa_4s = "\1\135\7\0\2\uffff";
    static final String dfa_5s = "\10\uffff\1\2\1\1";
    static final String dfa_6s = "\1\uffff\1\2\1\3\1\4\1\5\1\6\1\1\1\0\2\uffff}>";
    static final String[] dfa_7s = {
            "\5\10\6\uffff\5\10\1\uffff\1\10\1\uffff\3\10\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\72\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1246:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_7 = input.LA(1);

                         
                        int index13_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalBlangDsl()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index13_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_6 = input.LA(1);

                         
                        int index13_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalBlangDsl()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index13_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_1 = input.LA(1);

                         
                        int index13_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalBlangDsl()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index13_1);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA13_2 = input.LA(1);

                         
                        int index13_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalBlangDsl()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index13_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA13_3 = input.LA(1);

                         
                        int index13_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalBlangDsl()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index13_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA13_4 = input.LA(1);

                         
                        int index13_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalBlangDsl()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index13_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA13_5 = input.LA(1);

                         
                        int index13_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalBlangDsl()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index13_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\13\uffff";
    static final String dfa_9s = "\1\1\12\uffff";
    static final String dfa_10s = "\1\4\1\uffff\10\0\1\uffff";
    static final String dfa_11s = "\1\135\1\uffff\10\0\1\uffff";
    static final String dfa_12s = "\1\uffff\1\2\10\uffff\1\1";
    static final String dfa_13s = "\2\uffff\1\2\1\3\1\6\1\7\1\4\1\5\1\0\1\1\1\uffff}>";
    static final String[] dfa_14s = {
            "\5\1\6\uffff\5\1\1\uffff\1\1\1\uffff\3\1\3\uffff\5\1\1\2\1\3\10\1\1\4\1\5\1\6\1\7\1\10\1\11\54\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 1960:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_8 = input.LA(1);

                         
                        int index23_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalBlangDsl()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_9 = input.LA(1);

                         
                        int index23_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalBlangDsl()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_2 = input.LA(1);

                         
                        int index23_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalBlangDsl()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_3 = input.LA(1);

                         
                        int index23_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalBlangDsl()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_6 = input.LA(1);

                         
                        int index23_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalBlangDsl()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_7 = input.LA(1);

                         
                        int index23_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalBlangDsl()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_4 = input.LA(1);

                         
                        int index23_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalBlangDsl()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalBlangDsl()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\1\42\2\uffff\1\43\7\uffff";
    static final String dfa_16s = "\1\61\2\uffff\1\56\7\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\3\1\6";
    static final String dfa_18s = "\13\uffff}>";
    static final String[] dfa_19s = {
            "\1\6\1\3\10\uffff\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\12\12\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "2036:2: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )";
        }
    }
    static final String dfa_20s = "\122\uffff";
    static final String dfa_21s = "\1\2\121\uffff";
    static final String dfa_22s = "\1\4\1\0\120\uffff";
    static final String dfa_23s = "\1\135\1\0\120\uffff";
    static final String dfa_24s = "\2\uffff\1\2\116\uffff\1\1";
    static final String dfa_25s = "\1\uffff\1\0\120\uffff}>";
    static final String[] dfa_26s = {
            "\5\2\6\uffff\5\2\1\uffff\1\2\1\uffff\1\1\2\2\3\uffff\101\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "2937:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_1 = input.LA(1);

                         
                        int index42_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index42_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_27s = "\44\uffff";
    static final String dfa_28s = "\1\4\2\0\41\uffff";
    static final String dfa_29s = "\1\134\2\0\41\uffff";
    static final String dfa_30s = "\3\uffff\2\1\1\2\35\uffff\1\3";
    static final String dfa_31s = "\1\0\1\1\1\2\41\uffff}>";
    static final String[] dfa_32s = {
            "\4\5\1\1\6\uffff\1\5\7\uffff\1\2\1\uffff\1\43\1\uffff\1\4\6\uffff\1\5\14\uffff\1\3\2\uffff\2\5\4\uffff\1\5\6\uffff\2\5\2\uffff\1\5\1\uffff\1\5\3\uffff\3\5\2\uffff\15\5\1\uffff\1\5",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "2956:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_0 = input.LA(1);

                         
                        int index41_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA41_0==RULE_ID) ) {s = 1;}

                        else if ( (LA41_0==23) ) {s = 2;}

                        else if ( (LA41_0==47) && (synpred18_InternalBlangDsl())) {s = 3;}

                        else if ( (LA41_0==27) && (synpred18_InternalBlangDsl())) {s = 4;}

                        else if ( ((LA41_0>=RULE_STRING && LA41_0<=RULE_DECIMAL)||LA41_0==15||LA41_0==34||(LA41_0>=50 && LA41_0<=51)||LA41_0==56||(LA41_0>=63 && LA41_0<=64)||LA41_0==67||LA41_0==69||(LA41_0>=73 && LA41_0<=75)||(LA41_0>=78 && LA41_0<=90)||LA41_0==92) ) {s = 5;}

                        else if ( (LA41_0==25) ) {s = 35;}

                         
                        input.seek(index41_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_1 = input.LA(1);

                         
                        int index41_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalBlangDsl()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index41_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA41_2 = input.LA(1);

                         
                        int index41_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalBlangDsl()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index41_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_33s = {
            "\5\2\6\uffff\5\2\1\uffff\1\2\1\uffff\3\2\3\uffff\43\2\1\1\35\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "3054:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_1 = input.LA(1);

                         
                        int index43_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index43_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_34s = "\40\uffff";
    static final String dfa_35s = "\1\4\26\uffff\1\0\10\uffff";
    static final String dfa_36s = "\1\134\26\uffff\1\0\10\uffff";
    static final String dfa_37s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\6\uffff\1\6\11\uffff\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\10\1\11";
    static final String dfa_38s = "\1\0\26\uffff\1\1\10\uffff}>";
    static final String[] dfa_39s = {
            "\4\14\1\5\6\uffff\1\2\7\uffff\1\35\12\uffff\1\5\34\uffff\2\14\2\uffff\1\26\1\uffff\1\3\3\uffff\1\27\1\30\1\31\2\uffff\5\5\1\1\4\14\1\32\1\33\1\34\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = dfa_34;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "3099:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_0 = input.LA(1);

                         
                        int index45_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA45_0==83) ) {s = 1;}

                        else if ( (LA45_0==15) ) {s = 2;}

                        else if ( (LA45_0==69) ) {s = 3;}

                        else if ( (LA45_0==92) && (synpred20_InternalBlangDsl())) {s = 4;}

                        else if ( (LA45_0==RULE_ID||LA45_0==34||(LA45_0>=78 && LA45_0<=82)) ) {s = 5;}

                        else if ( ((LA45_0>=RULE_STRING && LA45_0<=RULE_DECIMAL)||(LA45_0>=63 && LA45_0<=64)||(LA45_0>=84 && LA45_0<=87)) ) {s = 12;}

                        else if ( (LA45_0==67) ) {s = 22;}

                        else if ( (LA45_0==73) ) {s = 23;}

                        else if ( (LA45_0==74) ) {s = 24;}

                        else if ( (LA45_0==75) ) {s = 25;}

                        else if ( (LA45_0==88) ) {s = 26;}

                        else if ( (LA45_0==89) ) {s = 27;}

                        else if ( (LA45_0==90) ) {s = 28;}

                        else if ( (LA45_0==23) ) {s = 29;}

                         
                        input.seek(index45_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_23 = input.LA(1);

                         
                        int index45_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalBlangDsl()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index45_23);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_40s = "\46\uffff";
    static final String dfa_41s = "\1\4\2\0\43\uffff";
    static final String dfa_42s = "\1\134\2\0\43\uffff";
    static final String dfa_43s = "\3\uffff\2\1\1\2\40\uffff";
    static final String dfa_44s = "\1\0\1\1\1\2\43\uffff}>";
    static final String[] dfa_45s = {
            "\4\5\1\1\6\uffff\1\5\7\uffff\1\2\3\uffff\1\4\6\uffff\1\5\14\uffff\1\3\2\uffff\2\5\4\uffff\1\5\6\uffff\3\5\1\uffff\1\5\1\uffff\1\5\3\uffff\22\5\1\uffff\1\5",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = dfa_40;
            this.eof = dfa_40;
            this.min = dfa_41;
            this.max = dfa_42;
            this.accept = dfa_43;
            this.special = dfa_44;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "3591:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA54_0 = input.LA(1);

                         
                        int index54_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA54_0==RULE_ID) ) {s = 1;}

                        else if ( (LA54_0==23) ) {s = 2;}

                        else if ( (LA54_0==47) && (synpred24_InternalBlangDsl())) {s = 3;}

                        else if ( (LA54_0==27) && (synpred24_InternalBlangDsl())) {s = 4;}

                        else if ( ((LA54_0>=RULE_STRING && LA54_0<=RULE_DECIMAL)||LA54_0==15||LA54_0==34||(LA54_0>=50 && LA54_0<=51)||LA54_0==56||(LA54_0>=63 && LA54_0<=65)||LA54_0==67||LA54_0==69||(LA54_0>=73 && LA54_0<=90)||LA54_0==92) ) {s = 5;}

                         
                        input.seek(index54_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA54_1 = input.LA(1);

                         
                        int index54_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalBlangDsl()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index54_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA54_2 = input.LA(1);

                         
                        int index54_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalBlangDsl()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index54_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 54, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_46s = "\43\uffff";
    static final String dfa_47s = "\1\4\1\0\41\uffff";
    static final String dfa_48s = "\1\134\1\0\41\uffff";
    static final String dfa_49s = "\2\uffff\1\2\37\uffff\1\1";
    static final String dfa_50s = "\1\uffff\1\0\41\uffff}>";
    static final String[] dfa_51s = {
            "\5\2\6\uffff\1\2\7\uffff\1\1\12\uffff\1\2\14\uffff\1\2\2\uffff\2\2\4\uffff\1\2\6\uffff\2\2\2\uffff\1\2\1\uffff\1\2\3\uffff\3\2\2\uffff\15\2\1\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_46;
            this.eof = dfa_46;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_49;
            this.special = dfa_50;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "4057:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_InternalBlangDsl()) ) {s = 34;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_52s = "\42\uffff";
    static final String dfa_53s = "\1\4\2\0\37\uffff";
    static final String dfa_54s = "\1\134\2\0\37\uffff";
    static final String dfa_55s = "\3\uffff\1\1\1\2\35\uffff";
    static final String dfa_56s = "\1\0\1\1\1\2\37\uffff}>";
    static final String[] dfa_57s = {
            "\4\4\1\1\6\uffff\1\4\7\uffff\1\2\12\uffff\1\4\14\uffff\1\3\2\uffff\2\4\4\uffff\1\4\6\uffff\2\4\2\uffff\1\4\1\uffff\1\4\3\uffff\3\4\2\uffff\15\4\1\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[][] dfa_57 = unpackEncodedStringArray(dfa_57s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_52;
            this.eof = dfa_52;
            this.min = dfa_53;
            this.max = dfa_54;
            this.accept = dfa_55;
            this.special = dfa_56;
            this.transition = dfa_57;
        }
        public String getDescription() {
            return "4126:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_0 = input.LA(1);

                         
                        int index60_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA60_0==RULE_ID) ) {s = 1;}

                        else if ( (LA60_0==23) ) {s = 2;}

                        else if ( (LA60_0==47) && (synpred28_InternalBlangDsl())) {s = 3;}

                        else if ( ((LA60_0>=RULE_STRING && LA60_0<=RULE_DECIMAL)||LA60_0==15||LA60_0==34||(LA60_0>=50 && LA60_0<=51)||LA60_0==56||(LA60_0>=63 && LA60_0<=64)||LA60_0==67||LA60_0==69||(LA60_0>=73 && LA60_0<=75)||(LA60_0>=78 && LA60_0<=90)||LA60_0==92) ) {s = 4;}

                         
                        input.seek(index60_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalBlangDsl()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_2 = input.LA(1);

                         
                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_InternalBlangDsl()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index60_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "5255:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA83_1 = input.LA(1);

                         
                        int index83_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index83_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 83, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "5274:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_0 = input.LA(1);

                         
                        int index82_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA82_0==RULE_ID) ) {s = 1;}

                        else if ( (LA82_0==23) ) {s = 2;}

                        else if ( (LA82_0==47) && (synpred32_InternalBlangDsl())) {s = 3;}

                        else if ( (LA82_0==27) && (synpred32_InternalBlangDsl())) {s = 4;}

                        else if ( ((LA82_0>=RULE_STRING && LA82_0<=RULE_DECIMAL)||LA82_0==15||LA82_0==34||(LA82_0>=50 && LA82_0<=51)||LA82_0==56||(LA82_0>=63 && LA82_0<=64)||LA82_0==67||LA82_0==69||(LA82_0>=73 && LA82_0<=75)||(LA82_0>=78 && LA82_0<=90)||LA82_0==92) ) {s = 5;}

                        else if ( (LA82_0==25) ) {s = 35;}

                         
                        input.seek(index82_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA82_1 = input.LA(1);

                         
                        int index82_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalBlangDsl()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index82_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA82_2 = input.LA(1);

                         
                        int index82_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalBlangDsl()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index82_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "5372:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA84_1 = input.LA(1);

                         
                        int index84_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index84_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 84, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_58s = {
            "\5\2\6\uffff\5\2\1\uffff\1\2\1\uffff\3\2\3\uffff\5\2\1\1\73\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_58 = unpackEncodedStringArray(dfa_58s);

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_58;
        }
        public String getDescription() {
            return "5531:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA88_1 = input.LA(1);

                         
                        int index88_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index88_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 88, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "5588:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA91_1 = input.LA(1);

                         
                        int index91_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index91_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 91, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "5607:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_0 = input.LA(1);

                         
                        int index90_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA90_0==RULE_ID) ) {s = 1;}

                        else if ( (LA90_0==23) ) {s = 2;}

                        else if ( (LA90_0==47) && (synpred36_InternalBlangDsl())) {s = 3;}

                        else if ( (LA90_0==27) && (synpred36_InternalBlangDsl())) {s = 4;}

                        else if ( ((LA90_0>=RULE_STRING && LA90_0<=RULE_DECIMAL)||LA90_0==15||LA90_0==34||(LA90_0>=50 && LA90_0<=51)||LA90_0==56||(LA90_0>=63 && LA90_0<=64)||LA90_0==67||LA90_0==69||(LA90_0>=73 && LA90_0<=75)||(LA90_0>=78 && LA90_0<=90)||LA90_0==92) ) {s = 5;}

                        else if ( (LA90_0==25) ) {s = 35;}

                         
                        input.seek(index90_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_1 = input.LA(1);

                         
                        int index90_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalBlangDsl()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index90_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_2 = input.LA(1);

                         
                        int index90_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalBlangDsl()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index90_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 90, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "5705:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA92_1 = input.LA(1);

                         
                        int index92_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index92_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 92, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_59s = "\1\41\121\uffff";
    static final String dfa_60s = "\1\4\40\0\61\uffff";
    static final String dfa_61s = "\1\135\40\0\61\uffff";
    static final String dfa_62s = "\41\uffff\1\2\57\uffff\1\1";
    static final String dfa_63s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\61\uffff}>";
    static final String[] dfa_64s = {
            "\1\27\1\23\1\24\1\25\1\1\6\uffff\1\12\4\41\1\uffff\1\41\1\uffff\1\40\2\41\3\uffff\5\41\1\15\17\41\1\10\1\7\4\41\1\6\6\41\1\17\1\20\2\41\1\31\1\41\1\13\3\41\1\32\1\33\1\34\2\41\1\2\1\3\1\4\1\5\1\16\1\11\1\21\1\22\1\26\1\30\1\35\1\36\1\37\1\41\1\14\1\41",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_59 = DFA.unpackEncodedString(dfa_59s);
    static final char[] dfa_60 = DFA.unpackEncodedStringToUnsignedChars(dfa_60s);
    static final char[] dfa_61 = DFA.unpackEncodedStringToUnsignedChars(dfa_61s);
    static final short[] dfa_62 = DFA.unpackEncodedString(dfa_62s);
    static final short[] dfa_63 = DFA.unpackEncodedString(dfa_63s);
    static final short[][] dfa_64 = unpackEncodedStringArray(dfa_64s);

    class DFA95 extends DFA {

        public DFA95(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 95;
            this.eot = dfa_20;
            this.eof = dfa_59;
            this.min = dfa_60;
            this.max = dfa_61;
            this.accept = dfa_62;
            this.special = dfa_63;
            this.transition = dfa_64;
        }
        public String getDescription() {
            return "6048:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA95_1 = input.LA(1);

                         
                        int index95_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA95_2 = input.LA(1);

                         
                        int index95_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA95_3 = input.LA(1);

                         
                        int index95_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA95_4 = input.LA(1);

                         
                        int index95_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA95_5 = input.LA(1);

                         
                        int index95_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA95_6 = input.LA(1);

                         
                        int index95_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA95_7 = input.LA(1);

                         
                        int index95_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA95_8 = input.LA(1);

                         
                        int index95_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA95_9 = input.LA(1);

                         
                        int index95_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA95_10 = input.LA(1);

                         
                        int index95_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA95_11 = input.LA(1);

                         
                        int index95_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA95_12 = input.LA(1);

                         
                        int index95_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA95_13 = input.LA(1);

                         
                        int index95_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA95_14 = input.LA(1);

                         
                        int index95_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA95_15 = input.LA(1);

                         
                        int index95_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA95_16 = input.LA(1);

                         
                        int index95_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA95_17 = input.LA(1);

                         
                        int index95_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA95_18 = input.LA(1);

                         
                        int index95_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA95_19 = input.LA(1);

                         
                        int index95_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA95_20 = input.LA(1);

                         
                        int index95_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA95_21 = input.LA(1);

                         
                        int index95_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA95_22 = input.LA(1);

                         
                        int index95_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA95_23 = input.LA(1);

                         
                        int index95_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA95_24 = input.LA(1);

                         
                        int index95_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA95_25 = input.LA(1);

                         
                        int index95_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA95_26 = input.LA(1);

                         
                        int index95_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA95_27 = input.LA(1);

                         
                        int index95_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA95_28 = input.LA(1);

                         
                        int index95_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA95_29 = input.LA(1);

                         
                        int index95_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA95_30 = input.LA(1);

                         
                        int index95_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA95_31 = input.LA(1);

                         
                        int index95_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA95_32 = input.LA(1);

                         
                        int index95_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred38_InternalBlangDsl()) ) {s = 81;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index95_32);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 95, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_65s = "\123\uffff";
    static final String dfa_66s = "\1\2\122\uffff";
    static final String dfa_67s = "\1\4\1\0\121\uffff";
    static final String dfa_68s = "\1\137\1\0\121\uffff";
    static final String dfa_69s = "\2\uffff\1\2\117\uffff\1\1";
    static final String dfa_70s = "\1\uffff\1\0\121\uffff}>";
    static final String[] dfa_71s = {
            "\5\2\6\uffff\5\2\1\uffff\1\2\1\uffff\3\2\3\uffff\5\2\1\1\73\2\1\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[] dfa_69 = DFA.unpackEncodedString(dfa_69s);
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final short[][] dfa_71 = unpackEncodedStringArray(dfa_71s);

    class DFA113 extends DFA {

        public DFA113(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 113;
            this.eot = dfa_65;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "6706:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA113_1 = input.LA(1);

                         
                        int index113_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBlangDsl()) ) {s = 82;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index113_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 113, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA111 extends DFA {

        public DFA111(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 111;
            this.eot = dfa_65;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "6800:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA111_1 = input.LA(1);

                         
                        int index111_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred47_InternalBlangDsl()) ) {s = 82;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index111_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 111, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_72s = "\7\uffff";
    static final String dfa_73s = "\2\uffff\1\4\3\uffff\1\4";
    static final String dfa_74s = "\1\10\1\uffff\1\16\1\10\2\uffff\1\16";
    static final String dfa_75s = "\1\117\1\uffff\1\120\1\64\2\uffff\1\120";
    static final String dfa_76s = "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String dfa_77s = "\7\uffff}>";
    static final String[] dfa_78s = {
            "\1\2\106\uffff\1\1",
            "",
            "\1\4\55\uffff\1\3\5\uffff\1\4\15\uffff\1\4",
            "\1\6\53\uffff\1\5",
            "",
            "",
            "\1\4\55\uffff\1\3\5\uffff\1\4\15\uffff\1\4"
    };

    static final short[] dfa_72 = DFA.unpackEncodedString(dfa_72s);
    static final short[] dfa_73 = DFA.unpackEncodedString(dfa_73s);
    static final char[] dfa_74 = DFA.unpackEncodedStringToUnsignedChars(dfa_74s);
    static final char[] dfa_75 = DFA.unpackEncodedStringToUnsignedChars(dfa_75s);
    static final short[] dfa_76 = DFA.unpackEncodedString(dfa_76s);
    static final short[] dfa_77 = DFA.unpackEncodedString(dfa_77s);
    static final short[][] dfa_78 = unpackEncodedStringArray(dfa_78s);

    class DFA121 extends DFA {

        public DFA121(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 121;
            this.eot = dfa_72;
            this.eof = dfa_73;
            this.min = dfa_74;
            this.max = dfa_75;
            this.accept = dfa_76;
            this.special = dfa_77;
            this.transition = dfa_78;
        }
        public String getDescription() {
            return "7298:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004002L,0x0000000000010000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000002F0000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000800000800100L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x810C0004008081F0L,0x0000000017FFCE29L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004410100L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000800010800100L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000001L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000FE0000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000078000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000081C00000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0003F00C00000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000800400000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00F0000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x7000000000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000100L,0x000000000003C000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000400000100L,0x000000000007C000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000800000800100L,0x0000000040000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x7000000000800002L,0x0000000000000001L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x810C80040A8081F0L,0x0000000017FFCE29L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x7000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x810C0004008181F0L,0x0000000017FFCE29L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x810C0004008081F0L,0x0000000017FFCE2BL});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x810C8004088081F0L,0x0000000017FFFE2BL});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x810C0004008081F0L,0x0000000017FFFE2BL});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x810C0004008081F2L,0x0000000017FFFE2DL});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x810C0004008081F2L,0x0000000017FFFE29L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x810C8004008081F0L,0x0000000017FFCE29L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000800001810100L,0x00000000000001C0L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000140L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x810C0004008081F0L,0x0000000017FFFE2DL});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x810C0004008081F0L,0x0000000017FFFE29L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x810C0004008081F0L,0x0000000017FFCE2DL});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x810C0004028081F0L,0x0000000017FFCE29L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x810C0004008181F0L,0x0000000017FFFE29L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x810C0004008181F0L,0x0000000017FFFE2DL});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000800002L,0x0000000000000001L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000400800002L,0x0000000000000001L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000002000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x810C0004008081F2L,0x0000000017FFCE29L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000028000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000002L,0x0000000028000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000800002800100L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x1000000400000002L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000000044000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000100L,0x0000000000008000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000100L,0x0000000000020000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000102L});

}