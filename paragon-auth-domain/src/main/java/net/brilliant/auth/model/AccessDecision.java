/**
 * 
 */
package net.brilliant.auth.model;

/**
 * @author ducbq
 *
 */
public enum AccessDecision {
  ACCESS_DENIED, //Deny to access resources
  ACCESS_GRANTED, //Grant to access resources
  ACCESS_ABSTAIN //Not allowed nor Deny access resources, Decision will be take based on other voters
}
