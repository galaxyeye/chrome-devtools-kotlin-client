@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Detailed success or error status of the operation.
 * 'AlreadyExists' also signifies a successful operation, as the result
 * of the operation already exists und thus, the operation was abort
 * preemptively (e.g. a cache hit).
 */
@Serializable
public enum class TrustTokenOperationDoneStatus {
  @SerialName("Ok")
  OK,
  @SerialName("InvalidArgument")
  INVALID_ARGUMENT,
  @SerialName("MissingIssuerKeys")
  MISSING_ISSUER_KEYS,
  @SerialName("FailedPrecondition")
  FAILED_PRECONDITION,
  @SerialName("ResourceExhausted")
  RESOURCE_EXHAUSTED,
  @SerialName("AlreadyExists")
  ALREADY_EXISTS,
  @SerialName("ResourceLimited")
  RESOURCE_LIMITED,
  @SerialName("Unauthorized")
  UNAUTHORIZED,
  @SerialName("BadResponse")
  BAD_RESPONSE,
  @SerialName("InternalError")
  INTERNAL_ERROR,
  @SerialName("UnknownError")
  UNKNOWN_ERROR,
  @SerialName("FulfilledLocally")
  FULFILLED_LOCALLY,
  @SerialName("SiteIssuerLimit")
  SITE_ISSUER_LIMIT,
  UNKNOWN,
}
